package com.ada.redesocialspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank (message = "O nome é obrigatorio, não pode ser nulo ou vazio")
    private String nome;

    @NotBlank (message = "O sobrenome é obrigatorio, não pode ser nulo ou vazio")
    private String sobrenome;

    @NotBlank (message = "O CPF é obrigatorio, não pode ser nulo ou vazio")
    @CPF (message = "formato de CPF invalido")
    private String cpf;

    @NotBlank (message = "A data de nascimento é obrigatoria, não pode ser nula ou vazia")
    private String dataNascimento;

    @Size(min = 8,max = 8,message = "CEP invalido, digite apenas os numeros")
    private String cep;
}
