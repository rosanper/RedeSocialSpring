package com.ada.redesocialspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 6, max = 10)
    private String senha;

    @NotBlank
    private String usuarioId;
}
