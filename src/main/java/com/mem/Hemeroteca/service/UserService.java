package com.mem.Hemeroteca.service;


import com.mem.Hemeroteca.model.Usuario;

import java.util.List;

public interface UserService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Long id, Usuario nuevoUsuario);
    void eliminarUsuario(Long id);
}
