package com.example.flujo_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "registro_flujo")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegistroFlujo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de pasaporte es obligatorio")
    @Size(max = 30, message = "El pasaporte no puede superar los 30 caracteres")
    @Column(nullable = false, length = 30)
    private String pasaporte;

    @NotBlank(message = "La etapa del flujo es obligatoria")
    @Size(max = 30, message = "La etapa no puede superar los 30 caracteres")
    @Column(nullable = false, length = 30)
    private String etapa;

    @NotBlank(message = "La fecha y hora de registro es obligatoria")
    @Size(max = 30, message = "La fecha/hora no puede superar los 30 caracteres")
    @Column(nullable = false, length = 30)
    private String fechaHora;
}