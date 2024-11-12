package com.sap.academia.desafiojava.api.curso;

import java.time.LocalDate;

public record CursoInfoDTO(String nome, String descricao, LocalDate dataCriacao) {
}
