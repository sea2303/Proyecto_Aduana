package com.example.servicio_reportes.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {

    @NotBlank(message = "El ID no puede estar vacio")
    private String id;
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    private String detalle;
    private String ficha;


}
