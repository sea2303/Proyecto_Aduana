package com.aduana.pasajero_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Modelo que representa la información de control aduanero y migratorio de un pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre(s) del pasajero", example = "Juan Carlos")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Schema(description = "Apellido(s) del pasajero", example = "Pérez Cotapos")
    private String apellido;

    @NotBlank(message = "El DNI o Pasaporte es obligatorio")
    @Size(min = 5, max = 20, message = "El documento debe tener entre 5 y 20 caracteres")
    @Column(unique = true, nullable = false)
    @Schema(description = "Número de documento de identidad, RUN o Pasaporte", example = "19876543-2")
    private String numeroDocumento;

    @NotBlank(message = "La nacionalidad es obligatoria")
    @Schema(description = "País de origen del pasajero", example = "Chilena")
    private String nacionalidad;

    @NotBlank(message = "Debe especificar el Paso Fronterizo de cruce")
    @Schema(description = "Nombre del complejo fronterizo de aduana", example = "Paso Los Libertadores")
    private String pasoFronterizo;

    @NotBlank(message = "Debe indicar el medio en el que viaja")
    @Schema(description = "Tipo de transporte utilizado", example = "Autobús")
    private String medioViaje;

    @Schema(description = "Nombre de la empresa si viaja en autobús colectivo", example = "Turbus")
    private String empresaAutobus;

    @NotNull(message = "Debe indicar la cantidad de equipaje/maletas")
    @Schema(description = "Cantidad total de maletas o bultos cargados", example = "2")
    private Integer cantidadBultos;

    @NotNull(message = "Es obligatorio completar la declaración jurada del SAG / SENASA")
    @Schema(description = "Indica si declara traer alimentos, plantas o productos orgánicos", example = "false")
    private Boolean declaraProductosAgropecuarios;

    @NotNull(message = "Debe indicar si trae mercancías comerciales o dinero que superen la franquicia")
    @Schema(description = "Indica si trae bienes que exceden el monto permitido sin pagar impuestos (ej: más de 10.000 USD)", example = "false")
    private Boolean excedeFranquicia;

    @Schema(description = "Estado interno de control tras la inspección (REVISIÓN, APROBADO, RETENIDO)", example = "APROBADO")
    private String estadoControl;
}