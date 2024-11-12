package com.sap.academia.desafiojava.api.DTO;

import java.time.LocalDate;

public record AlunoInfoDTO(String nome, String email, LocalDate data) {
}
