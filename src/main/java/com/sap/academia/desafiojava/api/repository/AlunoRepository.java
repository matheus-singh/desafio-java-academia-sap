package com.sap.academia.desafiojava.api.repository;

import com.sap.academia.desafiojava.api.repository.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
