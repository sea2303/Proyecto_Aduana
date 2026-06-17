package com.example.ayuda_service.repository;

import com.example.ayuda_service.model.Ayuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AyudaRepository extends JpaRepository<Ayuda, Long> {

}