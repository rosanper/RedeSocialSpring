package com.ada.redesocialspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    private String id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "conta")
    private List<Post> posts;
}
