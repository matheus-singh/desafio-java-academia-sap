package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.repository.entities.Aluno;
import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.controller.requests.AlunoRegistrationRequest;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
import com.sap.academia.desafiojava.api.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public void saveAluno(@Valid AlunoRegistrationRequest alunoRegistrationRequest) {
        Aluno aluno = new Aluno(alunoRegistrationRequest);
        alunoRepository.save(aluno);
    }

    public Page<AlunoInfoDTO> getAllAlunos(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(aluno -> inscricaoPopulator.convertAlunointoAlunoInfoDTO(aluno));
    }

    public Page<CursoInfoDTO> getCursosFromAluno(Long alunoId, Pageable pageable) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        List<CursoInfoDTO> cursoInfoDTOs = aluno.getCursos().stream()
                .map(curso -> inscricaoPopulator.convertCursointoCursoInfoDTO(curso))
                .toList();

        return new PageImpl<>(cursoInfoDTOs, pageable, cursoInfoDTOs.size());
    }
}
