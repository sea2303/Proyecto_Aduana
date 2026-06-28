package com.example.menores_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permisos_menores")
@Schema(description = "Modelo que representa la autorización y datos de control de un menor de edad")
public class Menor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID autoincremental de la base de datos", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre(s) del menor", example = "Diego Ignacio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Schema(description = "Apellidos del menor", example = "Poblete Soto")
    private String apellidos;

    @NotBlank(message = "El numero de documento es obligatorio")
    @Size(min = 8, max = 8, message = "El documento debe tener exactamente 8 caracteres")
    @Column(name = "numero_documento", nullable = false, unique = true)
    @Schema(description = "Número de documento de identidad (exactamente 8 caracteres)", example = "12345678")
    private String numeroDocumento;

    @NotNull(message = "La edad es obligatoria")
    @Schema(description = "Edad actual del menor de edad", example = "14")
    private Long edad;

    @NotNull(message = "El estado del permiso es obligatorio")
    @Schema(description = "Indica si el permiso notarial/legal está vigente", example = "true")
    private Boolean permisoVigente;

    @Schema(description = "Estado de control en el paso fronterizo/aduana", example = "APROBADO")
    private String estadoControl;
}