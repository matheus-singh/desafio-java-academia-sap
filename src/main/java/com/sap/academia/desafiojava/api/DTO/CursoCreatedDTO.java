package com.sap.academia.desafiojava.api.DTO;

import java.time.LocalDate;

public record CursoCreatedDTO (Long id, String nome, String descricao, LocalDate dataCriacao) {
}
