package com.iiht.restjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.iiht.restjpa")
public class FirstRestJpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestJpaMysqlApplication.class, args);
	}

}