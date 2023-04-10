package com.ada.redesocialspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private String cep;
    private String logradouro;
    private String cidade;
    private String estado;

    @OneToOne(mappedBy = "usuario")
    private Conta conta;

}
