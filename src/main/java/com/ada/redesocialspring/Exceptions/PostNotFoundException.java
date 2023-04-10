package com.ada.redesocialspring.Exceptions;

public class PostNotFoundException extends NotFoundException{
    public PostNotFoundException() {
        super("Post não existe!");
    }
}
