package com.sap.academia.desafiojava.api.repository;

import com.sap.academia.desafiojava.api.repository.entities.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
