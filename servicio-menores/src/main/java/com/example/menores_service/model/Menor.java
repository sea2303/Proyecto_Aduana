package com.example.menores_service.model;

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

public class Menor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "El numero de documento es obligatorio")
    @Size(min = 8, max = 8, message = "El documento debe tener exactamente 8 caracteres")
    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento;

    @NotNull(message = "La edad es obligatoria")
    private Long edad;

    @NotNull(message = "El estado del permiso es oblogatorio")
    private Boolean permisoVigente;

    private String estadoControl;

}
