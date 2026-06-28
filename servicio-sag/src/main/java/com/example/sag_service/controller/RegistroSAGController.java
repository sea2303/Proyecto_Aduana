package com.example.sag_service.controller;

import com.example.sag_service.model.RegistroSAG;
import com.example.sag_service.service.RegistroSAGService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sag")
@Tag(name = "Control SAG", description = "Endpoints para la declaración y revisión del SAG") // <-- ¡ESTO ES LO QUE SE AGREGA!
public class RegistroSAGController {

    private final RegistroSAGService registroSAGService;

    public RegistroSAGController(RegistroSAGService registroSAGService){
        this.registroSAGService = registroSAGService;
    }

    @GetMapping
    public List<RegistroSAG> listar(){
        return registroSAGService.obtenerTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar declaración por ID")
    public ResponseEntity<RegistroSAG> buscarPorId(@PathVariable Long id){
        return registroSAGService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva declaración")
    public RegistroSAG crear(@RequestBody RegistroSAG registroSAG){
        return registroSAGService.guardar(registroSAG);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una declaración")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        registroSAGService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}