package com.ada.redesocialspring.controllers;

import com.ada.redesocialspring.dto.UsuarioDTO;
import com.ada.redesocialspring.entities.Usuario;
import com.ada.redesocialspring.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("{id}")
    public Usuario getById(@PathVariable String id){
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario create(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable String id, @Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.updateUsuario(id, usuarioDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        usuarioService.deleteUsuario(id);
    }

}
