package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.aluno.Aluno;
import com.sap.academia.desafiojava.api.aluno.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.curso.Curso;
import com.sap.academia.desafiojava.api.curso.CursoInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class InscricaoPopulator {

    // Converte aluno nos DTOs para transferir dados
    public AlunoInfoDTO convertAlunointoAlunoInfoDTO(Aluno aluno){
        return new AlunoInfoDTO(aluno.getNome(), aluno.getEmail(), aluno.getDataCadastro());
    }

    // Converte Curso nos DTOs para transferir dados
    public CursoInfoDTO convertCursointoCursoInfoDTO(Curso curso){
        return new CursoInfoDTO(curso.getNome(), curso.getDescricao(), curso.getDataCriacao());
    }
}
