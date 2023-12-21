package com.mem.Hemeroteca.controller;


import com.mem.Hemeroteca.dto.UsuarioLoginRequest;
import com.mem.Hemeroteca.model.Usuario;
import com.mem.Hemeroteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hemeroteca/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioLoginRequest loginRequest) {
        Usuario usuario = usuarioService.findByUsername(loginRequest.getUsername());

        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            // Autenticación exitosa
            // Aquí podrías generar un token de sesión, establecer cookies, etc.

            // Construye un objeto JSON con la información del usuario, incluyendo el rol
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login exitoso");
            response.put("username", usuario.getUsername());
            response.put("roles", usuario.getRoles());

            return ResponseEntity.ok(response);
        } else {
            // Autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    // Otros métodos para manejar la autorización y roles
}
