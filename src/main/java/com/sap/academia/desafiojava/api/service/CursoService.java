package com.sap.academia.desafiojava.api.service;

import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.repository.entities.Curso;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
import com.sap.academia.desafiojava.api.controller.requests.CursoRegistrationRequest;
import com.sap.academia.desafiojava.api.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public void saveCurso(@Valid CursoRegistrationRequest cursoRegistrationRequest) {
        Curso curso = new Curso(cursoRegistrationRequest);
        cursoRepository.save(curso);
    }

    public Page<CursoInfoDTO> getAllCursos(Pageable pageable) {
        return cursoRepository.findAll(pageable).map(curso -> inscricaoPopulator.convertCursointoCursoInfoDTO(curso));
    }

    public Page<AlunoInfoDTO> getAlunosFromCurso(Long cursoId, Pageable pageable) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        List<AlunoInfoDTO> alunoInfoDTOs = curso.getAlunos().stream()
                .map(aluno -> inscricaoPopulator.convertAlunointoAlunoInfoDTO(aluno))
                .toList();

        return new PageImpl<>(alunoInfoDTOs, pageable, alunoInfoDTOs.size());
    }
}
