package com.sap.academia.desafiojava.api.repository.entities;

import com.sap.academia.desafiojava.api.controller.requests.CursoRegistrationRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;

    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos;

    public Curso (CursoRegistrationRequest cursoRegistrationRequest){
        this.nome = cursoRegistrationRequest.nome();
        this.descricao = cursoRegistrationRequest.descricao();
        this.dataCriacao = LocalDate.now();
        this.alunos = new HashSet<>();
    }
}
