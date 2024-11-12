package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.controller.requests.AlunoRegistrationRequest;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
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
    public Page<AlunoInfoDTO> getAllAlunos(final Pageable pageable){
        return alunoService.getAllAlunos(pageable);
    }

    @GetMapping("/{alunoId}/cursos")
    public Page<CursoInfoDTO> getCursosFromAluno(@PathVariable final Long alunoId, final Pageable pageable){
        return alunoService.getCursosFromAluno(alunoId, pageable);
    }
}
