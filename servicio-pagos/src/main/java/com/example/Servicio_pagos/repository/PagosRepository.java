package com.example.servicio_pagos.repository;

import com.example.servicio_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosRepository extends JpaRepository<Pago, Long> {
}