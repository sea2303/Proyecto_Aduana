package com.example.pdi_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cruces")
@Data
@Schema(description = "Registro de control migratorio de PDI")
public class Cruce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "12345678-9")
    private String rut;

    @Schema(example = "Juan Pérez")
    private String nombreCompleto;

    @Schema(example = "Chilena")
    private String nacionalidad;

    @Schema(example = "Argentina")
    private String destino;

    @Schema(example = "2026-06-20")
    private String fechaIngreso;

    @Schema(example = "APROBADO")
    private String estadoMigratorio;
}