package com.aduana.pasajero_service.controler;


import com.aduana.pasajero_service.model.Pasajero;
import com.aduana.pasajero_service.service.PasajeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/pasajeros")
@CrossOrigin(origins = "*")
public class PasajeroController {

    @Autowired
    private PasajeroService service;

    @GetMapping
    public List<Pasajero> listarTodos(){
        return service.obtenerTodos();
    }

    @GetMapping("/buscar/{documento}")
    public ResponseEntity<Pasajero> buscarPorDocumentos(@PathVariable String documento){
        return service.obtenerPorDocumento(documento).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero){
        return ResponseEntity.ok(service.registrarPasajero(pasajero));
    }

}
