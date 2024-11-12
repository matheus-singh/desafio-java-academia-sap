package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.DTO.AlunoInfoDTO;
import com.sap.academia.desafiojava.api.DTO.CursoCreatedDTO;
import com.sap.academia.desafiojava.api.DTO.CursoInfoDTO;
import com.sap.academia.desafiojava.api.controller.requests.CursoRegistrationRequest;
import com.sap.academia.desafiojava.api.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoCreatedDTO> cursoRegistration (
            @RequestBody @Valid final CursoRegistrationRequest cursoRegistrationRequest,
            final UriComponentsBuilder uriBuilder){
        CursoCreatedDTO cursoCreatedDTO = cursoService.saveCurso(cursoRegistrationRequest);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(cursoCreatedDTO.id()).toUri();
        return ResponseEntity.created(uri).body(cursoCreatedDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CursoInfoDTO>> getAllCursos(final Pageable pageable){
        Page<CursoInfoDTO> pageCursoInfoDTO = cursoService.getAllCursos(pageable);
        return ResponseEntity.ok(pageCursoInfoDTO);
    }

    @GetMapping("/{cursoId}/alunos")
    public ResponseEntity<Page<AlunoInfoDTO>> getAlunosFromCurso(@PathVariable final Long cursoId, final Pageable pageable) {
        Page<AlunoInfoDTO> pageAlunoInfoDTO = cursoService.getAlunosFromCurso(cursoId, pageable);
        return ResponseEntity.ok(pageAlunoInfoDTO);
    }
}
