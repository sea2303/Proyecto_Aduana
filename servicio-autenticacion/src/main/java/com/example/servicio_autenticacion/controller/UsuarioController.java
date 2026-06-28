package com.example.servicio_autenticacion.controller;

import com.example.servicio_autenticacion.model.Usuario;
import com.example.servicio_autenticacion.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/autenticacion")
@Tag(name = "Seguridad y Autenticación", description = "Endpoints para el registro e inicio de sesión de usuarios de Aduanas")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    @Operation(summary = "Registrar un nuevo usuario", description = "Crea un usuario en el sistema encriptando su contraseña con BCrypt")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Verifica las credenciales del usuario (RUT y Contraseña) para permitir el acceso")
    public ResponseEntity<?> login(@RequestBody LoginRequest credenciales) {

        boolean esValido = usuarioService.verificarCredenciales(credenciales.getRut(), credenciales.getContrasena());

        if (esValido) {
            return ResponseEntity.ok(Map.of("mensaje", "Inicio de sesion exitoso"));
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
        }
    }
}

@Data
@NoArgsConstructor
class LoginRequest {
    private String rut;
    private String contrasena;
}