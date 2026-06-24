package com.example.sag_service.controller;

import com.example.sag_service.model.RegistroSAG;
import com.example.sag_service.service.RegistroSAGService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sag")
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
    public ResponseEntity<RegistroSAG> buscarPorId(@PathVariable Long id){
        return registroSAGService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroSAG crear(@RequestBody RegistroSAG registroSAG){
        return registroSAGService.guardar(registroSAG);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        registroSAGService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
