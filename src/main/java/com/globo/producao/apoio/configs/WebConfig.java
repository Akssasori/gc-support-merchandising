package com.globo.producao.apoio.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import(SwaggerConfig.class)
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").
                setViewName("redirect:/swagger-ui/index.html");

        registry.addViewController("/swagger-ui")
                .setViewName("redirect:/swagger-ui/index.html");

        registry.addViewController("/documentation")
                .setViewName("redirect:/swagger-ui/index.html");

        registry.addViewController("/swagger-ui/documentation.html")
                .setViewName("redirect:/swagger-ui/index.html");
    }

}
