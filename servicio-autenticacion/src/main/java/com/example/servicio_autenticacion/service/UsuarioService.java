package com.example.servicio_autenticacion.service;

import com.example.servicio_autenticacion.client.PasajeroClient;
import com.example.servicio_autenticacion.model.Usuario;
import com.example.servicio_autenticacion.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasajeroClient pasajeroClient;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          PasajeroClient pasajeroClient) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.pasajeroClient = pasajeroClient;
    }

    public Usuario registrarUsuario(Usuario usuario) {

        logger.info("Intentando registrar usuario con RUT: {}", usuario.getRut());

        if (usuarioRepository.existsByRut(usuario.getRut())) {

            logger.warn("Intento de registrar un RUT ya existente: {}", usuario.getRut());

            throw new RuntimeException("El RUT ya se encuentra registrado");
        }

        try {

            logger.info("Verificando existencia del pasajero con RUT: {}", usuario.getRut());

            pasajeroClient.obtenerPasajeroPorRut(usuario.getRut());

            logger.info("Pasajero verificado correctamente.");

        } catch (Exception e) {

            logger.error("Error al comunicarse con pasajero-service: {}", e.getMessage());

            throw new RuntimeException("No se pudo verificar el RUT con el servicio de pasajeros vía REST.");
        }

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        logger.info("Usuario registrado correctamente con RUT: {}", usuarioGuardado.getRut());

        return usuarioGuardado;
    }

    public Optional<Usuario> buscarPorRut(String rut) {

        logger.info("Buscando usuario con RUT: {}", rut);

        return usuarioRepository.findByRut(rut);
    }

    public boolean verificarCredenciales(String rut, String contrasenaPlana) {

        logger.info("Verificando credenciales para el usuario: {}", rut);

        boolean credencialesValidas = usuarioRepository.findByRut(rut)
                .map(usuario -> passwordEncoder.matches(contrasenaPlana, usuario.getContrasena()))
                .orElse(false);

        if (credencialesValidas) {
            logger.info("Inicio de sesión exitoso para el usuario: {}", rut);
        } else {
            logger.warn("Intento de inicio de sesión fallido para el usuario: {}", rut);
        }

        return credencialesValidas;
    }
}