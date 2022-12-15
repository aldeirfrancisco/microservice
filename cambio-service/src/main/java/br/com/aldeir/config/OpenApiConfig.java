package br.com.aldeir.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info=
					@Info(title = "Cambio Service API",
					version= "v1",
					description = "Documentation of cambio service API"))
public class OpenApiConfig {
    
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(
					new io.swagger.v3.oas.models.info.Info()
					.title("Cambio Service API")
					.version("v1")
					.license(
						new License()
							.name("Apache 2.0")
							.url("http://springdoc.org")
					)
				);
	}
}
