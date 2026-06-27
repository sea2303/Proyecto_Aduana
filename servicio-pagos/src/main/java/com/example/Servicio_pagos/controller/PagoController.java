package com.example.Servicio_pagos.controller;

import com.example.Servicio_pagos.dto.IntentoPagoDTO;
import com.example.Servicio_pagos.model.Pago;
import com.example.Servicio_pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@Valid @RequestBody IntentoPagoDTO datos){
        Pago pagoRegistrado = pagoService.registrarPagoExitoso(datos);
        return ResponseEntity.ok(pagoRegistrado);
    }


}
