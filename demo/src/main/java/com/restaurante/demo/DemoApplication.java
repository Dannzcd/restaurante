package com.restaurante.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages={"com.restaurante.controllers", "com.restaurante.exceptions", "com.restaurante.exceptionHandlers"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(System.getProperty("user.dir") + "/src/main/resources");
	}

}
