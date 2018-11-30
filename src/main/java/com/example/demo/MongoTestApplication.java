package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.example.controller")

@EntityScan(basePackages = "com.example.model")
@ComponentScan("com.example.service")
@EnableMongoRepositories(basePackages = "com.example.dao")
@EnableAutoConfiguration
public class MongoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTestApplication.class, args);
		System.out.println("MongoTest Application Started");
	}
}
