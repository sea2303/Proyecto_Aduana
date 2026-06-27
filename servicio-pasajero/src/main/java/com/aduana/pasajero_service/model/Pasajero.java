package com.aduana.pasajero_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pasajeros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El DNI o Pasaporte es obligatorio")
    @Size(min = 5, max = 20, message = "El documento debe tener entre 5 y 20 caracteres")
    @Column(unique = true, nullable = false)
    private String numeroDocumento;

    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nacionalidad;

    @NotBlank(message = "Debe especificar el Paso Fronterizo de cruce")
    private String pasoFronterizo;

    @NotBlank(message = "Debe indicar el medio en el que viaja")
    private String medioViaje;

    private String empresaAutobus;

    @NotNull(message = "Debe indicar la cantidad de equipaje/maletas")
    private Integer cantidadBultos;

    @NotNull(message = "Es obligatorio completar la declaración jurada del SAG / SENASA")
    private Boolean declaraProductosAgropecuarios;

    @NotNull(message = "Debe indicar si trae mercancías comerciales o dinero que superen la franquicia")
    private Boolean excedeFranquicia;

    private String estadoControl;
}