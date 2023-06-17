package com.example.jpainvestigation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
@RepositoryRestResource
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@Configuration
public class JpaInvestigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaInvestigationApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder objectMapperBuilder) {
		ObjectMapper objectMapper = objectMapperBuilder.build();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return objectMapper;
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.mixIn(Object.class, HibernateMixin.class); // Apply mixin for all classes
		return builder;
	}

	// Mixin class to exclude hibernateLazyInitializer property
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	private static abstract class HibernateMixin {}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("spring boot data rest, with generic criteria search").description("Expand any endpoint to use the 'Try it out' customizable tests.").version("0.0.1")
						.license(new License().name("[click here to view minimal code on github]").url("https://github.com/fluidnotions/jpa-rest-experiments")));
	}


}
