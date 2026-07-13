package com.example.menores_service.controller;

import com.example.menores_service.model.Menor;
import com.example.menores_service.service.MenorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menores")
@CrossOrigin(origins = "*")
@Tag(name = "Control de Menores", description = "Endpoints para la gestión, registro y verificación de autorizaciones de viaje de menores en Aduanas")
public class MenorController {

    @Autowired
    private MenorService service;

    @GetMapping
    @Operation(summary = "Listar todos los menores registrados", description = "Retorna una lista completa de todos los menores con registros en el sistema de aduanas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    })
    public ResponseEntity<List<Menor>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/buscar/{numeroDocumento}")
    @Operation(summary = "Buscar menor por documento", description = "Busca el estado de autorización de un menor utilizando su número de documento o RUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menor encontrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró ningún menor con el documento ingresado")
    })
    public ResponseEntity<Menor> buscarPorDocumento(@PathVariable String numeroDocumento) {
        return service.obtenerPorDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo menor", description = "Ingresa un nuevo menor al sistema junto con su documentación o estado de permiso vigente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menor registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o faltantes")
    })
    public ResponseEntity<Menor> registrar(@Valid @RequestBody Menor menor) {
        Menor nuevoMenor = service.registrarMenor(menor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMenor);
    }
}