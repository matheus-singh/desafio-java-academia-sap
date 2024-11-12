package com.sap.academia.desafiojava.api.controller;

import com.sap.academia.desafiojava.api.inscricao.InscricaoDTO;
import com.sap.academia.desafiojava.api.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    // Metodo que aceita um body com alunoId e cursoId
    @PostMapping
    public void inscreverAluno(@RequestBody final InscricaoDTO inscricaoDTO) {
        inscricaoService.inscreverAluno(inscricaoDTO);
    }

    // Metodo que aceita variaveis na url para alunoId e cursoId
    @PostMapping("/aluno/{alunoId}/curso/{cursoId}")
    public void inscreverAluno(@PathVariable final Long alunoId, @PathVariable final Long cursoId) {
        inscricaoService.inscreverAluno(new InscricaoDTO(alunoId, cursoId));
    }
}