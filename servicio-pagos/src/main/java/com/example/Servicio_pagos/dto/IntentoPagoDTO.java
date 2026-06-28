package com.example.Servicio_pagos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class IntentoPagoDTO {

    @NotNull(message = "El ID de usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El ID de pedido no puede estar vacío")
    private Long pedidoId;

    @NotNull(message = "El monto no puede estar vacío")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    @NotBlank(message = "La pasarela de pago no puede estar en blanco")
    private String pasarela;
}