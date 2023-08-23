package com.restaurante.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexcontroller {
    @GetMapping("")
    public String getIndexHtml(){
        return "index";
    }
}
