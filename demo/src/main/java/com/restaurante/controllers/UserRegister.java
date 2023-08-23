package com.restaurante.controllers;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurante.data.entities.Usuario;
import com.restaurante.data.querymakers.UserQueryMaker;

import jakarta.servlet.http.HttpServletResponse;



@Controller
public class UserRegister {
    @RequestMapping(path = "/cadastrar-usuario", 
        method = RequestMethod.GET
    )
    public String cadastrar(){
        return "UsuarioCadastro";
    }

    @RequestMapping(path = "/cadastrar-usuario",
        method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, String>> cadastrarUsuario(@RequestBody Usuario usuario,HttpServletResponse request){
        HttpHeaders cabecalho = new HttpHeaders();
        Map<String, String> objetoJSON = new HashMap<String, String>();
        UserQueryMaker userQueryMaker = new UserQueryMaker("jdbc:postgresql://localhost:5432/Restaurante?user=postgres&password=M@caco1234");
        cabecalho.add("Content-Type", "application/json"); 

        System.out.println(usuario);
        
        //inserção de dados 
        try {
            userQueryMaker.generateUser(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
            objetoJSON.put("mensagem", e.getMessage());
            return new ResponseEntity<>(
                objetoJSON,
                cabecalho,
                HttpStatus.BAD_REQUEST
            );
        }

        objetoJSON.put("mensagem", "Cadastro efetuado com sucesso");

        return new ResponseEntity<Map<String, String>>(
                objetoJSON,
                cabecalho,
                HttpStatus.CREATED
            );
    }
}
