package com.mem.Hemeroteca.dto;


import com.mem.Hemeroteca.model.Usuario;
import com.mem.Hemeroteca.service.UsuarioService;

public class UsuarioLoginRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verificarCredenciales(UsuarioService usuarioService) {
        Usuario usuario = usuarioService.findByUsername(username);

        // Verificar si el usuario existe y las contraseñas coinciden
        return usuario != null && usuario.getPassword().equals(password);
    }
}

