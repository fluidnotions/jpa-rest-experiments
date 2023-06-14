package com.example.jpainvestigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SpringBootApplication
@RepositoryRestResource
public class JpaInvestigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaInvestigationApplication.class, args);
	}

}
