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
    private CruceRepository cruceRepository;

    public Cruce registrarCruce(Cruce cruce) {
        return cruceRepository.save(cruce);
    }


    public List<Cruce> listarCruces() {
        return cruceRepository.findAll();
    }


    public Optional<Cruce> buscarPorId(Long id) {
        return cruceRepository.findById(id);
    }

    public Cruce actualizarEstado(Long id, String estado) {
        Cruce cruce = cruceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cruce no encontrado"));

        cruce.setEstadoMigratorio(estado);
        return cruceRepository.save(cruce);
    }

    public void eliminarCruce(Long id) {
        cruceRepository.deleteById(id);
    }
}