package com.example.servicio_ayuda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ayudas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ayuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El ID de usuario no puede estar vacío")
    private String usuarioId;

    @NotBlank(message = "La descripción de la ayuda es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    private String estado;
}