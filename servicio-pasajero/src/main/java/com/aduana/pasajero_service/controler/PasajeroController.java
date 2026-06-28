package com.aduana.pasajero_service.controler;

import com.aduana.pasajero_service.model.Pasajero;
import com.aduana.pasajero_service.service.PasajeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/pasajeros")
@CrossOrigin(origins = "*")
@Tag(name = "Control de Pasajeros", description = "API de control aduanero")
public class PasajeroController {

    @Autowired
    private PasajeroService service;

    @GetMapping
    @Operation(summary = "Listar todos los pasajeros")
    public List<Pasajero> listarTodos(){
        return service.obtenerTodos();
    }

    @GetMapping("/buscar/{documento}")
    @Operation(summary = "Buscar pasajero por documento")
    public ResponseEntity<Pasajero> buscarPorDocumentos(@PathVariable String documento){
        return service.obtenerPorDocumento(documento).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo pasajero")
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero){
        return ResponseEntity.ok(service.registrarPasajero(pasajero));
    }
}