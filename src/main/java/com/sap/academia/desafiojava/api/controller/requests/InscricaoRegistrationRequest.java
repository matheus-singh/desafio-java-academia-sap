package com.sap.academia.desafiojava.api.controller.requests;

import jakarta.validation.constraints.NotBlank;

public record InscricaoRegistrationRequest(@NotBlank Long alunoId, @NotBlank Long cursoId) {
}
