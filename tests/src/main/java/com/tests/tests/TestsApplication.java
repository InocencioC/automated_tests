package com.tests.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsApplication.class, args);
	
		Calculator  calculator = new Calculator();
		System.out.println(calculator.sum(1,2));
	
	}
}
