package com.example.servicio_ayuda.model;

import jakarta.persistence.*;
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
    private String usuarioId;
    private String descripcion;
    private String estado;
}