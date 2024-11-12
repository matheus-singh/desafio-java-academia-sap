package com.sap.academia.desafiojava.api.DTO;

import java.time.LocalDate;

public record AlunoCreatedDTO(Long id, String nome, String email, LocalDate data) {
}
