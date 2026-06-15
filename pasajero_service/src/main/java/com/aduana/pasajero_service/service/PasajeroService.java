package com.aduana.pasajero_service.service;


import com.aduana.pasajero_service.model.Pasajero;
import com.aduana.pasajero_service.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PasajeroService {

    @Autowired
    private PasajeroRepository repository;

    public List<Pasajero> obtenerTodos(){
        return repository.findAll();
    }

    public Optional<Pasajero> obtenerPorDocumento(String documento){
        return repository.findByNumeroDocumento(documento);
    }

    public Pasajero registrarPasajero(Pasajero pasajero){
        if (pasajero.getEstadoControl() == null){
            pasajero.setEstadoControl("EN_REVISION");
        }
        return repository.save(pasajero);
    }


}
