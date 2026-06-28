package com.example.servicio_reportes.repository;


import com.example.servicio_reportes.model.Reporte;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ReporteRepository {
    public List<Reporte> obtenerDatosParaReporte(){
        return Arrays.asList(
                new Reporte("1", "Tomas", "Permiso de Menores aprovado", "Ficha-001"),
                new Reporte("2", "Carlos", "Control PDI Exitoso", "Ficha-002"),
                new Reporte("3", "Sean", "Revision SAG mascotas OK", "Ficha-003")
        );
    }

}
