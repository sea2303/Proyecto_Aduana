package com.example.Servicio_pagos.service;

import com.example.Servicio_pagos.dto.IntentoPagoDTO;
import com.example.Servicio_pagos.model.Pago;
import com.example.Servicio_pagos.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    private PagosRepository pagosRepository;


    public Pago registrarPagoExitoso(IntentoPagoDTO datos){
        Pago pago = new Pago();

        pago.setUsuarioId(datos.getUsuarioId());
        pago.setPedidoId(datos.getPedidoId());
        pago.setMonto(datos.getMonto());
        pago.setPasarela(datos.getPasarela());
        pago.setEstado("EXITOSO");

        Pago pagoGuardado = pagosRepository.save(pago);


        return pagoGuardado;
    }
}