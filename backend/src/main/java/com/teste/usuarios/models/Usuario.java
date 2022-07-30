package com.teste.usuarios.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "usuarios")
public class Usuario extends Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne()
    @JoinColumn(name = "cargo_id", nullable = false, referencedColumnName = "id")
    private Cargo cargo;

    @ManyToMany(mappedBy = "usuarios")
    private Collection<Perfil> perfis = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Collection<Perfil> perfis) {
        this.perfis = perfis;
    }
}
