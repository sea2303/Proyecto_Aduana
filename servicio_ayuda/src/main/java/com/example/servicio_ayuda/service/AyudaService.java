package com.example.servicio_ayuda.service;

import com.example.servicio_ayuda.model.Ayuda;
import com.example.servicio_ayuda.repository.AyudaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AyudaService {

    private final AyudaRepository ayudaRepository;

    public AyudaService(AyudaRepository ayudaRepository) {
        this.ayudaRepository = ayudaRepository;
    }

    public Ayuda crear(Ayuda solicitud) {
        solicitud.setEstado("pendiente");
        return ayudaRepository.save(solicitud);
    }

    public List<Ayuda> listar() {
        return ayudaRepository.findAll();
    }

    public Optional<Ayuda> buscarPorId(Long id) {
        return ayudaRepository.findById(id);
    }

    public Ayuda actualizarEstado(Long id, String estado) {
        Ayuda ayuda = ayudaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        ayuda.setEstado(estado);
        return ayudaRepository.save(ayuda);
    }
}