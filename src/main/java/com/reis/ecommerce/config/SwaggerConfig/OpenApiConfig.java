package com.reis.ecommerce.config.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI ecommerceOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("E-Commerce Backend API")
            .description("""
                    Event-driven, high-performance backend system.
                    Order → Payment → Event flow demo project.
                    """)
            .version("v1.0")
        );
  }
}
