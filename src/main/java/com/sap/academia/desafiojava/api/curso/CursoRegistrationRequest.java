package com.sap.academia.desafiojava.api.curso;
import jakarta.validation.constraints.NotBlank;

public record CursoRegistrationRequest(@NotBlank String nome, @NotBlank String descricao) {
}