package com.example.Gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 🚗 PARCHEO DE RUTA: Recibe "/api/vehiculos" y lo mapea al controlador real con "/api/v1/vehiculos"
                .route("vehiculo-service-route", r -> r.path("/vehiculo-service/api/vehiculos/**")
                        .filters(f -> f.setPath("/api/v1/vehiculos"))
                        .uri("lb://VEHICULO-SERVICE"))

                // 🔐 RUTA PARA AUTENTICACIÓN
                .route("servicio-autenticacion-route", r -> r.path("/servicio-autenticacion/**")
                        .filters(f -> f.rewritePath("/servicio-autenticacion/(?<remaining>.*)", "/${remaining}"))
                        .uri("lb://SERVICIO-AUTENTICACION"))
                .build();
    }
}