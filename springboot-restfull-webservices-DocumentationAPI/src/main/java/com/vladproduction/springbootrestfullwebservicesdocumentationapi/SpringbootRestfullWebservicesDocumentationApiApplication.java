package com.vladproduction.springbootrestfullwebservicesdocumentationapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "springboot-restfull-webservices-documentation-api",
                description = "documentation-api (SWAGGER-UI)",
                version = "v1.0",
                contact = @Contact(
                        name = "vladproduction",
                        email = "vladproduction@gmail.com",
                        url = "https://github.com/vladproduction"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/vladproduction/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "SpringBoot UserManagement Documentation",
                url = "https://github.com/vladproduction/user_management.html"
        )
)
public class SpringbootRestfullWebservicesDocumentationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfullWebservicesDocumentationApiApplication.class, args);
    }

}
