package com.example.ayuda_service.controller;

import com.example.ayuda_service.model.Ayuda;
import com.example.ayuda_service.service.AyudaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayudas")
public class AyudaController {

    private final AyudaService ayudaService;

    public AyudaController(AyudaService ayudaService) {
        this.ayudaService = ayudaService;
    }

    @GetMapping
    public List<Ayuda> listar() {
        return ayudaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ayuda> buscarPorId(@PathVariable Long id) {
        return ayudaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ayuda crear(@RequestBody Ayuda ayuda) {
        return ayudaService.guardar(ayuda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ayudaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}