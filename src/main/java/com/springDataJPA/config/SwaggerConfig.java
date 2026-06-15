package com.springDataJPA.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Spring Data JPA Learning Project")
                                .description(
                                        """
                                        This project demonstrates:
                                        
                                        - Spring Data JPA
                                        - MySQL Integration
                                        - User Management APIs
                                        - Car Management APIs
                                        - Swagger Documentation
                                        """
                                )
                                .version("1.0")
                                .contact(
                                        new Contact()
                                                .name("Hamid Raza")
                                                .email("hamid@example.com")
                                )
                                .license(
                                        new License()
                                                .name("Open Source")
                                )
                )

                .externalDocs(
                        new ExternalDocumentation()
                                .description("Project Documentation")
                                .url("https://github.com")
                );
    }
}