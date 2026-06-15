package com.example.menores_service.service;


import com.example.menores_service.model.Menor;
import com.example.menores_service.repository.MenorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenorService {

    @Autowired
    private MenorRepository repository;

    public List<Menor> obtenerTodos(){
        return repository.findAll();
    }

    public Optional<Menor> obtenerPorDocumento(String numeroDocumento){
        return repository.findByNumeroDocumento(numeroDocumento);
    }

    public Menor registrarMenor(Menor menor){
        if (menor.getPermisoVigente() != null && menor.getPermisoVigente()){
            menor.setEstadoControl("APROBADO");
        } else {
            menor.setEstadoControl("RECHAZADO");
        }
        return repository.save(menor);
    }

}
