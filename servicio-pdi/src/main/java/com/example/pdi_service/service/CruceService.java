package com.example.pdi_service.service;

import com.example.pdi_service.model.Cruce;
import com.example.pdi_service.repository.CruceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CruceService {

    @Autowired
    private CruceRepository repository;

    public Cruce registrarCruce(Cruce cruce) {
        return repository.save(cruce);
    }


    public List<Cruce> listarCruces() {
        return repository.findAll();
    }


    public Optional<Cruce> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cruce actualizarEstado(Long id, String estado) {
        Cruce cruce = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cruce no encontrado"));

        cruce.setEstadoMigratorio(estado);
        return repository.save(cruce);
    }

    public void eliminarCruce(Long id) {
        repository.deleteById(id);
    }
}