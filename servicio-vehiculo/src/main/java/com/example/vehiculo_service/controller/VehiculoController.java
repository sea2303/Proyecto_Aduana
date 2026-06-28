package com.example.vehiculo_service.controller;

import com.example.vehiculo_service.model.Vehiculo;
import com.example.vehiculo_service.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehiculos")
@CrossOrigin(origins = "*")
@Tag(name = "Control de Vehículos", description = "API de control aduanero para vehículos")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping
    @Operation(summary = "Listar todos los vehículos")
    public List<Vehiculo> listarTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/buscar/{patente}")
    @Operation(summary = "Buscar vehículo por patente")
    public ResponseEntity<Vehiculo> buscarPorPatente(@PathVariable String patente) {
        return service.obtenerPorPatente(patente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo vehículo")
    public ResponseEntity<Vehiculo> crear(@Valid @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(service.guardar(vehiculo));
    }
}