package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.aluno.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.curso.CursoInfoDTO;
import com.sap.academia.desafiojava.api.curso.CursoRegistrationRequest;
import com.sap.academia.desafiojava.api.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public void cursoRegistration (@RequestBody @Valid final CursoRegistrationRequest cursoRegistrationRequest){
        cursoService.saveCurso(cursoRegistrationRequest);
    }

    @GetMapping
    public Page<CursoInfoDTO> getAllCursos(final Pageable pageable){
        return cursoService.getAllCursos(pageable);
    }

    @GetMapping("/{cursoId}/alunos")
    public Page<AlunoInfoDTO> getAlunosFromCurso(@PathVariable final Long cursoId, final Pageable pageable) {
        return cursoService.getAlunosFromCurso(cursoId, pageable);
    }
}
