package com.rsjava.converter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .build().apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo(){
        return new ApiInfo(
                "Currency API",
                "Current courses based on NBP source",
                "1.00",
                "",
                new Contact("Robert",
                        "",
                        "stan.robert.1986@gmail.com"),
                "my own licence",
                "",
                Collections.emptyList()

        );
    }
}
