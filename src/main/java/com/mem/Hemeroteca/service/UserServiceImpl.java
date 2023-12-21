package com.mem.Hemeroteca.service;


import com.mem.Hemeroteca.model.Usuario;
import com.mem.Hemeroteca.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UsuarioRepositorio usuarioRepository;

    @Autowired
    public UserServiceImpl(UsuarioRepositorio usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica de validación y procesamiento si es necesario
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuarioExistente = obtenerUsuarioPorId(id);

        if (usuarioExistente != null) {
            // Actualiza los campos necesarios con los valores de nuevoUsuario
            usuarioExistente.setUsername(nuevoUsuario.getUsername());
            usuarioExistente.setPassword(nuevoUsuario.getPassword());
            usuarioExistente.setRoles(nuevoUsuario.getRoles());

            // Guarda el usuario actualizado en la base de datos
            return usuarioRepository.save(usuarioExistente);
        }

        return null; // Manejar el caso en el que el usuario no exista
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
