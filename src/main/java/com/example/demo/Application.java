package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.example.demo.calculator"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}






