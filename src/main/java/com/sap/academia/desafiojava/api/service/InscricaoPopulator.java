package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.DTO.AlunoCreatedDTO;
import com.sap.academia.desafiojava.api.DTO.CursoCreatedDTO;
import com.sap.academia.desafiojava.api.repository.entities.Aluno;
import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.repository.entities.Curso;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
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

    public AlunoCreatedDTO convertAlunointoAlunoCreatedDTO(Aluno aluno) {
        return new AlunoCreatedDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getDataCadastro());
    }

    public CursoCreatedDTO convertCursointoCursoCreatedDTO(Curso curso) {
        return new CursoCreatedDTO(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getDataCriacao());
    }
}
