package com.example.flujo_service.service;

import com.example.flujo_service.model.RegistroFlujo;
import com.example.flujo_service.repository.RegistroFlujoRepository;
import org.springframework.stereotype.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Service
public class RegistroFlujoService {

    private final RegistroFlujoRepository flujoRepository;
    private final VehiculoClient vehiculoClient; // Inyección de la interfaz de abajo

    public RegistroFlujoService(RegistroFlujoRepository flujoRepository, VehiculoClient vehiculoClient) {
        this.flujoRepository = flujoRepository;
        this.vehiculoClient = vehiculoClient;
    }

    public RegistroFlujo guardarPaso(RegistroFlujo registro) {
        // IE 2.4.1 — COMUNICACIÓN REST: Validación inter-servicio directa antes de guardar
        try {
            vehiculoClient.obtenerVehiculoPorPatente(registro.getPasaporte());
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo verificar el vehículo asociado en la aduana via REST: " + e.getMessage());
        }

        return flujoRepository.save(registro);
    }

    public List<RegistroFlujo> buscarPorPasaporte(String pasaporte) {
        return flujoRepository.findByPasaporte(pasaporte);
    }

    public List<RegistroFlujo> listarTodo() {
        return flujoRepository.findAll();
    }
}


@FeignClient(name = "vehiculo-service", path = "/api/vehiculos")
interface VehiculoClient {
    @GetMapping("/patente/{patente}")
    Object obtenerVehiculoPorPatente(@PathVariable("patente") String patente);
}