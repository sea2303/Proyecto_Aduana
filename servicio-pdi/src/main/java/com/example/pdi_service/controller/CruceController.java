package com.example.pdi_service.controller;

import com.example.pdi_service.model.Cruce;
import com.example.pdi_service.service.CruceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cruces")
@CrossOrigin("*")
@Tag(name = "Control PDI", description = "API de control migratorio")
public class CruceController {

    @Autowired
    private CruceService cruceService;

    @PostMapping
    @Operation(summary = "Registrar un cruce fronterizo")
    public ResponseEntity<Cruce> registrar(@RequestBody Cruce cruce) {
        return ResponseEntity.ok(cruceService.registrarCruce(cruce));
    }

    @GetMapping
    @Operation(summary = "Listar todos los cruces")
    public ResponseEntity<List<Cruce>> listar() {
        return ResponseEntity.ok(cruceService.listarCruces());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cruce por ID")
    public ResponseEntity<Cruce> buscar(@PathVariable Long id) {
        return cruceService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    @Operation(summary = "Actualizar estado migratorio")
    public ResponseEntity<Cruce> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(cruceService.actualizarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un registro de cruce")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cruceService.eliminarCruce(id);
        return ResponseEntity.noContent().build();
    }
}