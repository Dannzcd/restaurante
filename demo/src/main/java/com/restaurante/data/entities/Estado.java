package com.restaurante.data.entities;

public class Estado {
    private String nome;
    private String sigla;

    public Estado(String nome, String sigla) throws Exception{
        this.nome = nome;

        if (sigla.length() == 2)
            this.sigla = sigla;
        else
            throw new Exception("Sigla com formato invalido");
    }

    public String getNome() {
        return this.nome;
    }

    public String getSigla() {
        return this.sigla;
    }
}
