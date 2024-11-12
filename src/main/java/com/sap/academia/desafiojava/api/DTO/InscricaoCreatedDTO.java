package com.sap.academia.desafiojava.api.DTO;

import java.time.LocalDate;

public record InscricaoCreatedDTO (Long id, Long alunoId, Long cursoId, LocalDate dataInscricao) {
}
