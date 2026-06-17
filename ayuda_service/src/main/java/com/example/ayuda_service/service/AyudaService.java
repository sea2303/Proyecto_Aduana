package com.example.ayuda_service.service;

import com.example.ayuda_service.model.Ayuda;
import com.example.ayuda_service.repository.AyudaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AyudaService {

    private final AyudaRepository ayudaRepository;

    public AyudaService(AyudaRepository ayudaRepository) {
        this.ayudaRepository = ayudaRepository;
    }

    public List<Ayuda> obtenerTodas() {
        return ayudaRepository.findAll();
    }

    public Optional<Ayuda> obtenerPorId(Long id) {
        return ayudaRepository.findById(id);
    }

    public Ayuda guardar(Ayuda ayuda) {
        return ayudaRepository.save(ayuda);
    }

    public void eliminar(Long id) {
        ayudaRepository.deleteById(id);
    }
}