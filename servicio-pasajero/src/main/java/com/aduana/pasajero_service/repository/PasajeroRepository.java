package com.aduana.pasajero_service.repository;

import com.aduana.pasajero_service.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByNumeroDocumento(String numeroDocumento);
}
