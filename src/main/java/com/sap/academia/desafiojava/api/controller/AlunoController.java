package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.aluno.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.aluno.AlunoRegistrationRequest;
import com.sap.academia.desafiojava.api.curso.CursoInfoDTO;
import com.sap.academia.desafiojava.api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public void alunoRegistration (@RequestBody @Valid final AlunoRegistrationRequest alunoRegistrationRequest){
        alunoService.saveAluno(alunoRegistrationRequest);
    }

    @GetMapping
    public Page<AlunoInfoDTO> getAllAlunos(Pageable pageable){
        return alunoService.getAllAlunos(pageable);
    }

    @GetMapping("/{alunoId}/cursos")
    public Page<CursoInfoDTO> getCursosFromAluno(@PathVariable Long alunoId, Pageable pageable){
        return alunoService.getCursosFromAluno(alunoId, pageable);
    }
}