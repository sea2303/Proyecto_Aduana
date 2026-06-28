package com.example.servicio_reportes.service;

import com.example.servicio_reportes.model.Reporte;
import com.example.servicio_reportes.repository.ReporteRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    public ByteArrayInputStream generarExcel() throws Exception {
        List<Reporte> datos = reporteRepository.obtenerDatosParaReporte();
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("Datos");

        int rowIdx = 0;
        for (Reporte dato : datos) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(dato.getId());
            row.createCell(1).setCellValue(dato.getNombre());
            row.createCell(2).setCellValue(dato.getDetalle());
            row.createCell(3).setCellValue(dato.getFicha());
        }

        workbook.write(out);
        workbook.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generarPdf() throws Exception {
        List<Reporte> datos = reporteRepository.obtenerDatosParaReporte();
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        PdfPTable table = new PdfPTable(4);
        for (Reporte dato : datos) {
            table.addCell(dato.getId());
            table.addCell(dato.getNombre());
            table.addCell(dato.getDetalle());
            table.addCell(dato.getFicha());
        }

        document.add(table);
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}