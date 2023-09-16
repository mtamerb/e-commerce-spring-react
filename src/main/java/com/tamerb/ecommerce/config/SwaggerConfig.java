package com.tamerb.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@OpenAPIDefinition(
        info = @Info(
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Tamer Bilici",
                        email = "tamerbilici00@gmail.com",
                        url = "https://github.com/mtamerb"
                ),
                description = "This is a sample Spring Boot RESTful service using Springdoc OpenAPI and Swagger UI.",
                title = "E-Commerce API",
                version = "1.0.0",
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                ),
                termsOfService = "http://swagger.io/terms/"
        ),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "Local Server",
                        url = "http://localhost:8080"
                )/*,
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "Heroku Server",
                        url = "https://ecommerce-springboot.herokuapp.com"
                )*/
        }
)
/*
@SecurityScheme(
        name = "bearerAuth",
        scheme = "bearer",
        description = "JWT Authorization header using the Bearer scheme.",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

*/

public class SwaggerConfig {

}