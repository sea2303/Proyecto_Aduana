package com.example.flujo_service.repository;


import com.example.flujo_service.model.RegistroFlujo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroFlujoRepository extends JpaRepository<RegistroFlujo, Long> {
    List<RegistroFlujo> findByPasaporte(String pasaporte);
}
