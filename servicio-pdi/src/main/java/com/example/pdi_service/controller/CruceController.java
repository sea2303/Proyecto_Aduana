package com.example.pdi_service.controller;

import com.example.pdi_service.model.Cruce;
import com.example.pdi_service.service.CruceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cruces")
@CrossOrigin("*")
public class CruceController {

    @Autowired
    private CruceService cruceService;

    @PostMapping
    public ResponseEntity<Cruce> registrar(@RequestBody Cruce cruce) {
        return ResponseEntity.ok(cruceService.registrarCruce(cruce));
    }

    @GetMapping
    public ResponseEntity<List<Cruce>> listar() {
        return ResponseEntity.ok(cruceService.listarCruces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cruce> buscar(@PathVariable Long id) {
        return cruceService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Cruce> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {

        return ResponseEntity.ok(cruceService.actualizarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cruceService.eliminarCruce(id);
        return ResponseEntity.noContent().build();
    }
}