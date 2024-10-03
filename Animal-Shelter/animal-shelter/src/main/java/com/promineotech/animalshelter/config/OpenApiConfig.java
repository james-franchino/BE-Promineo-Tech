package com.promineotech.animalshelter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI documentation.
 * This class sets up the OpenAPI configuration for the Animal Shelter API.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configures the OpenAPI documentation for the Animal Shelter API.
     *
     * @return OpenAPI object containing API information
     */
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Animal Shelter API")
                        .description("API for managing animal shelter operations")
                        .version("1.0"));
    }
}
