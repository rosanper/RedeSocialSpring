package com.ada.redesocialspring.services;

import com.ada.redesocialspring.dto.UsuarioDTO;
import com.ada.redesocialspring.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(String id);
    Usuario createUsuario(UsuarioDTO usuarioDTO);
    Usuario updateUsuario(String id, UsuarioDTO usuarioDTO);
    void deleteUsuario(String id);
}
