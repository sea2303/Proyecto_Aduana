package com.example.servicio_ayuda.repository;

import com.example.servicio_ayuda.model.Ayuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyudaRepository extends JpaRepository<Ayuda, Long> {
}