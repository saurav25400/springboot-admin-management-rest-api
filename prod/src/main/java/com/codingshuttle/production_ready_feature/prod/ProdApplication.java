package com.codingshuttle.production_ready_feature.prod;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdApplication.class, args);
		System.out.println("Welcome to the Springboot Application");
	}


}
