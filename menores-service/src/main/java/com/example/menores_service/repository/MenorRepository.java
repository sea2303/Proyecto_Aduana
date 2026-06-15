package com.example.menores_service.repository;

import com.example.menores_service.model.Menor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MenorRepository extends JpaRepository<Menor, Long> {
    Optional<Menor> findByNumeroDocumento(String numeroDocumento);
}
