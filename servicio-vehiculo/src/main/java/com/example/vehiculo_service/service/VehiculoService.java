package com.example.vehiculo_service.service;

import com.example.vehiculo_service.model.Vehiculo;
import com.example.vehiculo_service.repository.VehiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> obtenerPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    public Optional<Vehiculo> obtenerPorPatente(String patente) {
        return vehiculoRepository.findByPatente(patente);
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        if (vehiculo.getPatente() != null) {
            vehiculo.setPatente(vehiculo.getPatente().trim().toUpperCase());
        }

        if (!vehiculo.isTienePermisoArgentina()) {
            System.out.println("ALERTA ADUANA: Sin permiso.");
        }

        return vehiculoRepository.save(vehiculo);
    }

    public void eliminar(Long id) {
        vehiculoRepository.deleteById(id);
    }
}