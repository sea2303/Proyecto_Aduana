package com.example.menores_service.controller;


import com.example.menores_service.model.Menor;
import com.example.menores_service.service.MenorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menores")
@CrossOrigin(origins = "*")
public class MenorController {

    @Autowired
    private MenorService service;

    @GetMapping
    public ResponseEntity<List<Menor>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/buscar/{numeroDocumento}")
    public ResponseEntity<Menor> buscarPorDocumento(@PathVariable String numeroDocumento) {
        return service.obtenerPorDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Menor> registrar(@Valid @RequestBody Menor menor) {
        Menor nuevoMenor = service.registrarMenor(menor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMenor);
    }
}