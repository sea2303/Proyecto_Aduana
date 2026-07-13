package com.example.vehiculo_service;

import com.example.vehiculo_service.model.Vehiculo;
import com.example.vehiculo_service.repository.VehiculoRepository;
import com.example.vehiculo_service.service.VehiculoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {

    @Mock
    private VehiculoRepository vehiculoRepository;

    @InjectMocks
    private VehiculoService vehiculoService;

    @Test
    void testGuardarVehiculoExitoso() {
        Vehiculo v = new Vehiculo();
        v.setPatente("   abcd12   ");
        v.setTienePermisoArgentina(true);

        Mockito.when(vehiculoRepository.save(Mockito.any(Vehiculo.class))).thenReturn(v);

        Vehiculo resultado = vehiculoService.guardar(v);

        assertNotNull(resultado);
        assertEquals("ABCD12", resultado.getPatente());
    }

    @Test
    void testGuardarVehiculoSinPermisoLanzaExcepcion() {
        Vehiculo v = new Vehiculo();
        v.setPatente("ABCD12");
        v.setTienePermisoArgentina(false);

        assertThrows(IllegalArgumentException.class, () -> {
            vehiculoService.guardar(v);
        });
    }

    @Test
    void testObtenerPorPatenteExiste() {
        Vehiculo v = new Vehiculo();
        v.setPatente("ABCD12");
        Mockito.when(vehiculoRepository.findByPatente("ABCD12")).thenReturn(Optional.of(v));

        Optional<Vehiculo> resultado = vehiculoService.obtenerPorPatente("ABCD12");

        assertTrue(resultado.isPresent());
        assertEquals("ABCD12", resultado.get().getPatente());
    }

    @Test
    void testObtenerPorPatenteNoExiste() {
        Mockito.when(vehiculoRepository.findByPatente("XYZ999")).thenReturn(Optional.empty());

        Optional<Vehiculo> resultado = vehiculoService.obtenerPorPatente("XYZ999");

        assertFalse(resultado.isPresent());
    }
}