package com.example.Servicio_pagos.repository;

import com.example.Servicio_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosRepository extends JpaRepository<Pago, Long> {
}
