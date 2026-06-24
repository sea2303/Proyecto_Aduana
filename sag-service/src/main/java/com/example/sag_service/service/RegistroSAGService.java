package com.example.sag_service.service;

import com.example.sag_service.model.RegistroSAG;
import com.example.sag_service.repository.RegistroSAGRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroSAGService {

    private final RegistroSAGRepository sagRepository;

    public RegistroSAGService(RegistroSAGRepository sagRepository){
        this.sagRepository = sagRepository;
    }

    public List<RegistroSAG> obtenerTodos(){
        return sagRepository.findAll();
    }

    public Optional<RegistroSAG> obtenerPorId(Long id){
        return sagRepository.findById(id);
    }

    public RegistroSAG guardar(RegistroSAG registro){
        return sagRepository.save(registro);
    }

    public void eliminar(Long id){
        sagRepository.deleteById(id);
    }

}
