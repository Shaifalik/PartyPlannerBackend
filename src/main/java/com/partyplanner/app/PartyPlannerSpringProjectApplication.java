package com.partyplanner.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.partyplanner.controller.AppController;

@EnableJpaRepositories(basePackages = "com.partyplanner.repos")
@SpringBootApplication
@EntityScan("com.partyplanner.models")
@ComponentScan(basePackages="com.partyplanner")
public class PartyPlannerSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyPlannerSpringProjectApplication.class, args);
	}
}
