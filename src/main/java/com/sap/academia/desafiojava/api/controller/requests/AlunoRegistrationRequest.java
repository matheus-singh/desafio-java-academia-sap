package com.sap.academia.desafiojava.api.controller.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AlunoRegistrationRequest (@NotBlank String nome, @NotBlank @Email String email) {
}
