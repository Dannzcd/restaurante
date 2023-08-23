package com.restaurante.data.entities;

public class Cliente extends Usuario{
    
    private final String cpf;
    private Cidade cidade;
    private Estado estado;

    public Cliente(String email, String nome, String senha1, String senha2, 
    String cpf, Estado estado, Cidade cidade) throws Exception, StringIndexOutOfBoundsException {
        super(email, nome, senha1, senha2);
        //TODO Auto-generated constructor stub
        if (cpf.length() == 14){
            this.cpf = cpf;
        }
        else
            throw new StringIndexOutOfBoundsException("CPF com tamanho inválido");
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

}
