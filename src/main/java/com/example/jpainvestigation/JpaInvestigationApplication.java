package com.example.jpainvestigation;

import com.example.jpainvestigation.autorest.config.RepositoryRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@ComponentScan({"com.example.jpainvestigation.autorest", "com.example.jpainvestigation.data"})
public class JpaInvestigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaInvestigationApplication.class, args);
	}

}
