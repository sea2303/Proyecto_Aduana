package com.example.servicio_ayuda.controller;

import com.example.servicio_ayuda.model.Ayuda;
import com.example.servicio_ayuda.service.AyudaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayuda")
@Tag(name = "Soporte y Ayuda")
public class AyudaController {

    private final AyudaService ayudaService;

    public AyudaController(AyudaService ayudaService) {
        this.ayudaService = ayudaService;
    }

    @PostMapping("/tickets")
    @Operation(summary = "Crear ticket")
    public ResponseEntity<Ayuda> crearTicket(@RequestBody Ayuda solicitud) {
        return ResponseEntity.ok(ayudaService.crear(solicitud));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar tickets")
    public ResponseEntity<List<Ayuda>> listarTickets() {
        return ResponseEntity.ok(ayudaService.listar());
    }

    @PutMapping("/estado/{id}")
    @Operation(summary = "Actualizar estado")
    public ResponseEntity<Ayuda> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        return ResponseEntity.ok(ayudaService.actualizarEstado(id, estado));
    }
}