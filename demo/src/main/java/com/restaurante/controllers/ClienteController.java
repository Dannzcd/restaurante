package com.restaurante.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClienteController {
    
    @RequestMapping(path = "/cliente/pagina-principal", method = RequestMethod.GET)
    public String getClienteRegisterPage(){
        return "Cliente";
    }

    
}
