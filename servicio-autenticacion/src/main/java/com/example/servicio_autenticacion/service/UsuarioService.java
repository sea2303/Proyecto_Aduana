package com.example.servicio_autenticacion.service;

import com.example.servicio_autenticacion.model.Usuario;
import com.example.servicio_autenticacion.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByRut(usuario.getRut())) {
            throw new RuntimeException("El RUT ya se encuentra registrado");
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
