package com.example.servicio_autenticacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String rut;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @Email
    @Column(nullable = false, length = 100)
    private String correo;

    @Size(min = 8)
    @Column(nullable = false, length = 255)
    private String contrasena;

    @Column(nullable = false, length = 30)
    private String rol;
}
