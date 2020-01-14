package com.example.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoJpaApplication.class, args);
	}

}
