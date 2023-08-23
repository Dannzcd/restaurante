package com.restaurante.data.entities;

import com.restaurante.exceptions.ApiRequestException;

public class Usuario {
    private String email;
    private String senha;
    private String nome;

    public Usuario(String email, String nome, String senha1, String senha2) throws ApiRequestException{
        this.email = email;
        this.nome = nome;
        if (senha1.equals(senha2)){
            this.senha = senha1;
        }
        else{
            ApiRequestException e = new ApiRequestException("Senhas não coincidem");
            System.out.println(e.getClass()) ;
            throw e;
        }
            
            
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    @Override
    public String toString() {
        return "Email: " + this.email + "\n" +
        "Nome: " + this.nome + "\n";
    }
}
