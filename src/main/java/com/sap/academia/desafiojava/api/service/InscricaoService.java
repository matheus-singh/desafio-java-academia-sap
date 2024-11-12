package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.aluno.Aluno;
import com.sap.academia.desafiojava.api.curso.Curso;
import com.sap.academia.desafiojava.api.inscricao.Inscricao;
import com.sap.academia.desafiojava.api.inscricao.InscricaoDTO;
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

    public void inscreverAluno(InscricaoDTO inscricaoDTO) {
        Aluno aluno = alunoRepository.findById(inscricaoDTO.alunoId())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(inscricaoDTO.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        Inscricao inscricao = new Inscricao(aluno, curso);
        inscricaoRepository.save(inscricao);
    }
}