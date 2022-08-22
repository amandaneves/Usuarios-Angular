package com.teste.usuariosspring.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "cargos")
public class Cargo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "cargo")
    private Collection<Usuario> usuarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}