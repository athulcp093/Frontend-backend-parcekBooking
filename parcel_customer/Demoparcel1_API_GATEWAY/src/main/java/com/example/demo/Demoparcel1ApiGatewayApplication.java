package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
public class Demoparcel1ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demoparcel1ApiGatewayApplication.class, args);
	}

}
