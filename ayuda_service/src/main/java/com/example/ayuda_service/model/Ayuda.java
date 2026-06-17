package com.example.ayuda_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ayudas")
@Data
public class Ayuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
}