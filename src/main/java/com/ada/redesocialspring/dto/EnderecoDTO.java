package com.ada.redesocialspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {


    private String cep;

    private String logradouro;

    @JsonProperty("localidade")
    private String cidade;

    @JsonProperty("uf")
    private String estado;
}
