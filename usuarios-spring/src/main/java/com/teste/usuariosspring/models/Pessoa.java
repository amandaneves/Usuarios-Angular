package com.teste.usuariosspring.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.usuariosspring.enums.Genero;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa extends DataCadastro {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 1)
    private String genero;

    @Transient
    private Genero valorGenero;

    @PostLoad
    void fillTransient() {
        if (genero != null) {
            this.valorGenero = Genero.of(genero);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (valorGenero != null) {
            this.genero = valorGenero.getLetra();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
