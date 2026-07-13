package com.example.pdi_service.controller;

import com.example.pdi_service.model.Cruce;
import com.example.pdi_service.service.CruceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cruces")
@CrossOrigin("*")
@Tag(name = "Control PDI", description = "API de control migratorio y alertas de policía internacional")
public class CruceController {

    @Autowired
    private CruceService cruceService;

    @PostMapping
    @Operation(summary = "Registrar un cruce fronterizo", description = "Registra un nuevo evento de movimiento migratorio de entrada o salida del país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cruce fronterizo registrado con éxito"),
            @ApiResponse(responseCode = "400", description = "Error en el formato de los datos enviados")
    })
    public ResponseEntity<Cruce> registrar(@RequestBody Cruce cruce) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cruceService.registrarCruce(cruce));
    }

    @GetMapping
    @Operation(summary = "Listar todos los cruces", description = "Obtiene el historial completo de cruces migratorios registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial recuperado exitosamente")
    })
    public ResponseEntity<List<Cruce>> listar() {
        return ResponseEntity.ok(cruceService.listarCruces());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cruce por ID", description = "Busca los detalles de un evento de cruce específico mediante su identificador numérico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cruce encontrado"),
            @ApiResponse(responseCode = "404", description = "ID de cruce no existente en los registros")
    })
    public ResponseEntity<Cruce> buscar(@PathVariable Long id) {
        return cruceService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    @Operation(summary = "Actualizar estado migratorio", description = "Modifica la situación o estado actual de un registro de cruce en particular")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "El registro de cruce no fue localizado")
    })
    public ResponseEntity<Cruce> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(cruceService.actualizarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un registro de cruce", description = "Borra físicamente un evento de cruce de la base de datos migratoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Registro eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "No se pudo eliminar porque el registro no existe")
    })
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cruceService.eliminarCruce(id);
        return ResponseEntity.noContent().build();
    }
}