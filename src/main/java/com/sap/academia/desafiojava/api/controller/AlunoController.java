package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.DTO.AlunoCreatedDTO;
import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.controller.requests.AlunoRegistrationRequest;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
import com.sap.academia.desafiojava.api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoCreatedDTO> alunoRegistration (
            @RequestBody @Valid final AlunoRegistrationRequest alunoRegistrationRequest,
            final UriComponentsBuilder uriBuilder){
        AlunoCreatedDTO alunoCreatedDTO = alunoService.saveAluno(alunoRegistrationRequest);
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(alunoCreatedDTO.id()).toUri();
        return ResponseEntity.created(uri).body(alunoCreatedDTO);
    }

    @GetMapping
    public ResponseEntity<Page<AlunoInfoDTO>> getAllAlunos(final Pageable pageable){
        Page<AlunoInfoDTO> pageAlunoInfoDTO = alunoService.getAllAlunos(pageable);
        return ResponseEntity.ok(pageAlunoInfoDTO);
    }

    @GetMapping("/{alunoId}/cursos")
    public ResponseEntity<Page<CursoInfoDTO>> getCursosFromAluno(@PathVariable final Long alunoId, final Pageable pageable){
        Page<CursoInfoDTO> pageCursoInfoDTO = alunoService.getCursosFromAluno(alunoId, pageable);
        return ResponseEntity.ok(pageCursoInfoDTO);
    }
}
