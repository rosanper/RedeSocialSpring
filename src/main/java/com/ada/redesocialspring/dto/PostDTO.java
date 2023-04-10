package com.ada.redesocialspring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @NotBlank
    private String conteudo;

//    @NotBlank
//    private String contaId;
}
