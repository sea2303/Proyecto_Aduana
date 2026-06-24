package com.example.Servicio_pagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ServicioPagosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioPagosApplication.class, args);
    }

}
