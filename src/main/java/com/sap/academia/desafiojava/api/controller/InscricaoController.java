package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.DTO.InscricaoCreatedDTO;
import com.sap.academia.desafiojava.api.controller.requests.InscricaoRegistrationRequest;
import com.sap.academia.desafiojava.api.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    // Metodo que aceita um body com alunoId e cursoId
    @PostMapping
    public ResponseEntity<InscricaoCreatedDTO> inscreverAluno(
            @RequestBody @Valid final InscricaoRegistrationRequest inscricaoRegistrationRequest,
            final UriComponentsBuilder uriBuilder) {
        InscricaoCreatedDTO inscricaoCreatedDTO = inscricaoService.inscreverAluno(inscricaoRegistrationRequest);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(inscricaoCreatedDTO.id()).toUri();
        return ResponseEntity.created(uri).body(inscricaoCreatedDTO);
    }

    // Metodo que aceita variaveis na url para alunoId e cursoId
    @PostMapping("/aluno/{alunoId}/curso/{cursoId}")
    public ResponseEntity<InscricaoCreatedDTO> inscreverAluno(
            @PathVariable final Long alunoId, @PathVariable final Long cursoId,
            final UriComponentsBuilder uriBuilder) {
        InscricaoCreatedDTO inscricaoCreatedDTO = inscricaoService.inscreverAluno(new InscricaoRegistrationRequest(alunoId, cursoId));
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(inscricaoCreatedDTO.id()).toUri();
        return ResponseEntity.created(uri).body(inscricaoCreatedDTO);
    }
}