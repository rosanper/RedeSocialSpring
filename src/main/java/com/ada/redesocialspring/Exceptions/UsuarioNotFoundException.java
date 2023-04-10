package com.ada.redesocialspring.Exceptions;

public class UsuarioNotFoundException extends NotFoundException{
    public UsuarioNotFoundException() {
        super("Usuário não exisste!");
    }
}
