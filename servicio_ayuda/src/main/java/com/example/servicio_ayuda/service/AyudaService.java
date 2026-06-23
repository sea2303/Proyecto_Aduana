package com.example.servicio_ayuda.service;

import com.example.servicio_ayuda.model.Ayuda;
import com.example.servicio_ayuda.repository.AyudaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AyudaService {

    private final AyudaRepository repository;

    public AyudaService(AyudaRepository repository) {
        this.repository = repository;
    }

    public Ayuda crear(Ayuda solicitud) {
        solicitud.setEstado("pendiente");
        return repository.save(solicitud);
    }

    public List<Ayuda> listar() {
        return repository.findAll();
    }

    public Optional<Ayuda> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Ayuda actualizarEstado(Long id, String estado) {
        Ayuda s = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        s.setEstado(estado);
        return repository.save(s);
    }
}