package com.sap.academia.desafiojava.api.repository;

import com.sap.academia.desafiojava.api.repository.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
