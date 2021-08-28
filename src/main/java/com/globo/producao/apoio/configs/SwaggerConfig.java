package com.globo.producao.apoio.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Profile("prod")
public class SwaggerConfig {

    /**
     * Return Docket with SWAGGER_2 configuration.
     * @return return Docket with SWAGGER_2 configuration
     * @see Docket
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.globo.producao.apoio.controllers"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "GC-OPERATION-SUPPORT REST API",
                "Documentação do REST API - Gestão de Criativos",
                "1.0",
                null,
                null,
                null, null, Collections.emptyList());
    }

}
