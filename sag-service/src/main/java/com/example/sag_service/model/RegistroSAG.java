package com.example.sag_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "registro_sag")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegistroSAG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 20, message = "El pasajeroId debe tener entre 5 y 20 caracteres")
    @Column(nullable = false, length = 20)
    private String pasajeroId;

    @Size(min = 4, max = 30, message = "El tipo de declaración debe tener entre 4 y 30 caracteres")
    @Column(nullable = false, length = 30)
    private String tipoDeDeclaracion;

    @Size(min = 10, max = 255, message = "La descripción debe tener al menos 10 caracteres")
    @Column(nullable = false, length = 255)
    private String descripcionObjetos;

    @Size(min = 5, max = 255, message = "Las observaciones deben tener al menos 5 caracteres")
    @Column(nullable = false, length = 255)
    private String observaciones;

    @Column(nullable = false)
    private Boolean aprobado;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate(){
        this.fechaRegistro = LocalDateTime.now();
    }
}