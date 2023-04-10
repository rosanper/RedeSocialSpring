package com.ada.redesocialspring.config;

import com.ada.redesocialspring.Exceptions.ContaNotFoundException;
import com.ada.redesocialspring.Exceptions.NotFoundException;
import com.ada.redesocialspring.Exceptions.PostNotFoundException;
import com.ada.redesocialspring.Exceptions.UsuarioNotFoundException;
import com.ada.redesocialspring.dto.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ContaNotFoundException.class, PostNotFoundException.class, UsuarioNotFoundException.class})
    public ErroDTO handlerNotFound(NotFoundException exception){
        return ErroDTO.builder().mensagem(exception.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErroDTO SQLException(SQLIntegrityConstraintViolationException exception){
        return ErroDTO.builder().mensagem(exception.getMessage()).build();
    }

}
