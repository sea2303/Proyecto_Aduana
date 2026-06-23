package com.example.servicio_ayuda.controller;

import com.example.servicio_ayuda.model.Ayuda;
import com.example.servicio_ayuda.service.AyudaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayuda")
public class AyudaController {

    private final AyudaService service;

    public AyudaController(AyudaService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<Ayuda> crear(@RequestBody Ayuda solicitud) {
        return ResponseEntity.ok(service.crear(solicitud));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ayuda>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ayuda> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Ayuda> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(service.actualizarEstado(id, estado));
    }
}