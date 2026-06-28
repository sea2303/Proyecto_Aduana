package com.example.flujo_service.controller;

import com.example.flujo_service.model.RegistroFlujo;
import com.example.flujo_service.service.RegistroFlujoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flujo")
@Tag(name = "Control de Flujo Aduanero")
public class RegistroFlujoController {

    private final RegistroFlujoService flujoService;

    public RegistroFlujoController(RegistroFlujoService flujoService) {
        this.flujoService = flujoService;
    }

    @PostMapping("/guardar")
    @Operation(summary = "Registrar un nuevo paso en el flujo")
    public ResponseEntity<RegistroFlujo> guardarPaso(@RequestBody RegistroFlujo registro) {
        return ResponseEntity.ok(flujoService.guardarPaso(registro));
    }

    @GetMapping("/pasaporte/{pasaporte}")
    @Operation(summary = "Buscar historial de flujos por número de pasaporte")
    public ResponseEntity<List<RegistroFlujo>> buscarPorPasaporte(@PathVariable String pasaporte) {
        return ResponseEntity.ok(flujoService.buscarPorPasaporte(pasaporte));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos los registros de flujo")
    public ResponseEntity<List<RegistroFlujo>> listarTodo() {
        return ResponseEntity.ok(flujoService.listarTodo());
    }
}