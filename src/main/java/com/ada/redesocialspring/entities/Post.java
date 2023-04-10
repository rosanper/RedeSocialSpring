package com.ada.redesocialspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private String id;
    private String conteudo;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @JsonIgnore
    private Conta conta;
}
