package com.esp.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.esp.controller", "com.esp.repository"})
public class PlayerRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerRestAppApplication.class, args);
	}
}
