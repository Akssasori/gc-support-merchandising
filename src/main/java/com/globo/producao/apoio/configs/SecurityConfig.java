package com.globo.producao.apoio.configs;

import com.globo.ad.core.security.JWTAuthenticationFilter;
import com.globo.ad.core.security.SecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends SecurityConfigurer {

    @Override
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/documentation",
                "/swagger-ui/**",
                "/v3/api-docs/**",
                "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(new String[]{"/"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/status"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/actuator/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/swagger-ui.html"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/swagger-ui.html/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/swagger-resources/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/webjars/springfox-swagger-ui/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/webjars/swagger-resources/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/v2/api-docs/**"}).permitAll()
                .antMatchers(HttpMethod.GET, new String[]{"/csrf"}).permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
