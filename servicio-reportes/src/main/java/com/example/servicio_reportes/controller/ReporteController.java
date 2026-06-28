package com.example.servicio_reportes.controller;

import com.example.servicio_reportes.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
@Tag(name = "Reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/excel")
    @Operation(summary = "Descargar Excel")
    public ResponseEntity<InputStreamResource> descargarExcel() throws Exception {
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=reporte.xlsx")
                .body(new InputStreamResource(reporteService.generarExcel()));
    }

    @GetMapping("/pdf")
    @Operation(summary = "Descargar PDF")
    public ResponseEntity<InputStreamResource> descargarPdf() throws Exception {
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=reporte.pdf")
                .body(new InputStreamResource(reporteService.generarPdf()));
    }
}