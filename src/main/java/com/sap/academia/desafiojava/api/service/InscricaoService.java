package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.DTO.InscricaoCreatedDTO;
import com.sap.academia.desafiojava.api.repository.entities.Aluno;
import com.sap.academia.desafiojava.api.repository.entities.Curso;
import com.sap.academia.desafiojava.api.repository.entities.Inscricao;
import com.sap.academia.desafiojava.api.controller.requests.InscricaoRegistrationRequest;
import com.sap.academia.desafiojava.api.repository.AlunoRepository;
import com.sap.academia.desafiojava.api.repository.CursoRepository;
import com.sap.academia.desafiojava.api.repository.InscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public InscricaoCreatedDTO inscreverAluno(InscricaoRegistrationRequest inscricaoRegistrationRequest) {
        Aluno aluno = alunoRepository.findById(inscricaoRegistrationRequest.alunoId())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(inscricaoRegistrationRequest.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        Inscricao inscricao = new Inscricao(aluno, curso);
        inscricaoRepository.save(inscricao);
        return new InscricaoCreatedDTO(inscricao.getId(), inscricao.getAluno().getId(), inscricao.getCurso().getId(), inscricao.getDataInscricao());
    }
}