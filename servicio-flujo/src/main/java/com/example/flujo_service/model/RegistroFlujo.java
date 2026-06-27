package com.example.flujo_service.model;


import jakarta.persistence.*;
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
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String pasaporte;

    @Column(nullable = false, length = 30)
    private String etapa;

    @Column(nullable = false, length = 30)
    private String fechaHora;
}
