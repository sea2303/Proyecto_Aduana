package com.example.servicio_ayuda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitudes_ayuda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ayuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String rutUsuario;

    @Column(nullable = false, length = 50)
    private String tipoAyuda;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado;
}