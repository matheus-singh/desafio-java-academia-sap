package com.sap.academia.desafiojava.api.aluno;

import java.time.LocalDate;

public record AlunoInfoDTO(String nome, String email, LocalDate data) {
}
