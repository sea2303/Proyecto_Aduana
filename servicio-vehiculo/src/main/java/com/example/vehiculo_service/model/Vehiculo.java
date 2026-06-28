package com.example.vehiculo_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Datos del vehículo en control aduanero")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "BBCC-12")
    private String patente;

    @Schema(example = "Toyota")
    private String marca;

    @Schema(example = "Rav4")
    private String modelo;

    @Schema(example = "12345678-9")
    private String propietarioRut;

    @Schema(example = "true")
    private boolean tienePermisoArgentina;
}