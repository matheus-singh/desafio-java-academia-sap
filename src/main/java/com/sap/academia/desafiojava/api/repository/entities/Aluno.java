package com.sap.academia.desafiojava.api.repository.entities;

import com.sap.academia.desafiojava.api.controller.requests.AlunoRegistrationRequest;
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
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    @ManyToMany
    @JoinTable(name = "Inscricao",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursos;

    public Aluno(AlunoRegistrationRequest alunoRegistrationRequest){
        this.nome = alunoRegistrationRequest.nome();
        this.email = alunoRegistrationRequest.email();
        this.dataCadastro = LocalDate.now();
        this.cursos = new HashSet<>();
    }
}
