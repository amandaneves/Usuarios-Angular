package com.teste.usuarios.enums;

import java.util.stream.Stream;

public enum Genero {
    MASCULINO("M"), FEMININO("F");

    private String letra;

    private Genero(String letra) {
        this.letra = letra;
    }

    public String getLetra() {
        return letra;
    }

    public static Genero of(String genero) {
        return Stream.of(Genero.values())
                .filter(g -> g.getLetra().equals(genero))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return this.letra.equals("M") ? "Masculino" : "Feminino";
    }
}
