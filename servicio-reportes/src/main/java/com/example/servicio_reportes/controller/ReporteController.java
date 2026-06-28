package com.example.servicio_reportes.controller;

import com.example.servicio_reportes.service.ReporteService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/excel")
    public ResponseEntity<InputStreamResource> descargarExcel() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=reporte.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new InputStreamResource(reporteService.generarExcel()));
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> descargarPdf() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=reporte.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new InputStreamResource(reporteService.generarPdf()));
    }
}