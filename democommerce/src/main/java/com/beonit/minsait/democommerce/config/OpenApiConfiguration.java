package com.beonit.minsait.democommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Open api configuration class.
 */
@OpenAPIDefinition(
        info =
        @Info(
                title = "Beonit-Minsait ecommerce artifact",
                description = "Beonit-Minsait ecommerce API",
                version = "v1"))
@Configuration
public class OpenApiConfiguration {
}
