package com.example.pdi_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cruces")
@Data
public class Cruce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rut;
    private String nombreCompleto;
    private String nacionalidad;
    private String destino;
    private String fechaIngreso;
    private String estadoMigratorio;
}