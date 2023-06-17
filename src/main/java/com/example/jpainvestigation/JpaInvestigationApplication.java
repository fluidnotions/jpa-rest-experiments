package com.example.jpainvestigation;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@Configuration
@ComponentScan({"com.fluidnotions.autorest", "com.example"})
public class JpaInvestigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaInvestigationApplication.class, args);
	}


	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("spring boot data rest, with generic criteria search").description("Expand any endpoint to use the 'Try it out' customizable tests.").version("0.0.1")
						.license(new License().name("[click here to view minimal code on github]").url("https://github.com/fluidnotions/jpa-rest-experiments")));
	}




}
