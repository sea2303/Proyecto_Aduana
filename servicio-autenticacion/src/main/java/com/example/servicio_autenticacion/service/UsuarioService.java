package com.example.servicio_autenticacion.service;

import com.example.servicio_autenticacion.client.PasajeroClient;
import com.example.servicio_autenticacion.model.Usuario;
import com.example.servicio_autenticacion.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasajeroClient pasajeroClient;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, PasajeroClient pasajeroClient) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.pasajeroClient = pasajeroClient;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByRut(usuario.getRut())) {
            throw new RuntimeException("El RUT ya se encuentra registrado");
        }

        try {
            pasajeroClient.obtenerPasajeroPorRut(usuario.getRut());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo verificar el RUT con el servicio de pasajeros via REST: " + e.getMessage());
        }

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorRut(String rut) {
        return usuarioRepository.findByRut(rut);
    }

    public boolean verificarCredenciales(String rut, String contrasenaPlana) {
        return usuarioRepository.findByRut(rut)
                .map(usuario -> passwordEncoder.matches(contrasenaPlana, usuario.getContrasena()))
                .orElse(false);
    }
}