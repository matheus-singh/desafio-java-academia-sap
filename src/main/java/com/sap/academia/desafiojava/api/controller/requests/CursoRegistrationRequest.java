package com.sap.academia.desafiojava.api.controller.requests;
import jakarta.validation.constraints.NotBlank;

public record CursoRegistrationRequest(@NotBlank String nome, @NotBlank String descricao) {
}