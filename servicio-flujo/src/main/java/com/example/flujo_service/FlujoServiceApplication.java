package com.example.flujo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlujoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlujoServiceApplication.class, args);
	}

}
