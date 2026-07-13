package com.example.servicio_autenticacion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pasajero-service", path = "/api/pasajeros")
public interface PasajeroClient {

    @GetMapping("/rut/{rut}")
    Object obtenerPasajeroPorRut(@PathVariable("rut") String rut);
}