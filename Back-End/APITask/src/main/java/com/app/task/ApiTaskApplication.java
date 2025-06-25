package com.app.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTaskApplication.class, args);
	}

}
