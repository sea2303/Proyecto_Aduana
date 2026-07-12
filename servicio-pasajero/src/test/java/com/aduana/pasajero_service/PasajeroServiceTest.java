package com.aduana.pasajero_service;

import com.aduana.pasajero_service.model.Pasajero;
import com.aduana.pasajero_service.repository.PasajeroRepository;
import com.aduana.pasajero_service.service.PasajeroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PasajeroServiceTest {

    @Mock
    private PasajeroRepository repository;

    @InjectMocks
    private PasajeroService service;

    @Test
    void testRegistrarPasajero() {
        Pasajero p = new Pasajero();
        p.setNumeroDocumento("12345678-k");
        p.setEstadoControl(null);
        Mockito.when(repository.save(p)).thenReturn(p);
        Pasajero resultado = service.registrarPasajero(p);
        assertNotNull(resultado);
        assertEquals("EN_REVISION", resultado.getEstadoControl());
        assertEquals("12345678-K", resultado.getNumeroDocumento());
    }

    @Test
    void testVerificarPasajeroExiste() {
        Pasajero p = new Pasajero();
        Mockito.when(repository.findByNumeroDocumento("12345678-K")).thenReturn(Optional.of(p));
        boolean existe = service.verificarPasajeroExiste("12345678-k");
        assertTrue(existe);
    }

    @Test
    void testVerificarPasajeroNoExiste() {
        Mockito.when(repository.findByNumeroDocumento("99999999-9")).thenReturn(Optional.empty());
        boolean existe = service.verificarPasajeroExiste("99999999-9");
        assertFalse(existe);
    }
}