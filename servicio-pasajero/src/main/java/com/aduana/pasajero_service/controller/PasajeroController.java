package com.aduana.pasajero_service.controller;

import com.aduana.pasajero_service.model.Pasajero;
import com.aduana.pasajero_service.service.PasajeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pasajeros")
@Tag(name = "Pasajeros", description = "Endpoints para la administración y validación de pasajeros en frontera")
@CrossOrigin(origins = "*")
public class PasajeroController {

    private final PasajeroService service;

    public PasajeroController(PasajeroService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos los pasajeros")
    public List<Pasajero> listarTodos() {
        return service.obtenerTodos();
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo pasajero")
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero) {
        return ResponseEntity.ok(service.registrarPasajero(pasajero));
    }

    @GetMapping("/verificar/{documento}")
    @Operation(summary = "Validar existencia por Número de Documento")
    public boolean verificarPasajeroExiste(@PathVariable String documento) {
        return service.verificarPasajeroExiste(documento);
    }
}