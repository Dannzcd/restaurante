package com.restaurante.data.entities;

public class Cidade {
    private String nome;
    private boolean is_capital;
    private Estado estado;

    public Cidade(String nome, boolean is_capital, Estado estado){
        this.nome = nome;
        this.is_capital = is_capital;
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean is_capital(){
        return this.is_capital;
    }

    public Estado getEstado() {
        return this.estado;
    }
}
