package com.example.flujo_service.service;

import com.example.flujo_service.model.RegistroFlujo;
import com.example.flujo_service.repository.RegistroFlujoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroFlujoService {
    @Autowired
    private RegistroFlujoRepository repository;

    public RegistroFlujo guardarPaso(RegistroFlujo registro){
        return repository.save(registro);
    }

    public List<RegistroFlujo> buscarPorPasaporte(String pasaporte){
        return repository.findByPasaporte(pasaporte);
    }

    public List<RegistroFlujo> listarTodo(){
        return repository.findAll();
    }
}

