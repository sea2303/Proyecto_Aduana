package com.example.Servicio_pagos.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de usuario no puede estar vacio")
    @Column(nullable = false)
    private Long usuarioId;

    @NotNull(message = "El ID de pedido no puede estar vacio")
    @Column(nullable = false)
    private Long pedidoId;

    @NotNull(message = "El monto no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a cero")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @NotBlank(message = "La pasarela de pago no puede estar en blanco")
    @Column(nullable = false)
    private String pasarela;

    @NotBlank(message = "El estado no puede estar en blanco")
    @Column(nullable = false)
    private String estado;
}