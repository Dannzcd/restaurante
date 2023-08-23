package com.restaurante.controllers;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.restaurante.data.querymakers.UserQueryMaker;

@Controller
public class TestContoller {
    @GetMapping("/teste")
    public String testeUsuarios(Model model){
        UserQueryMaker userQueryMaker = new UserQueryMaker("jdbc:postgresql://localhost:5432/Restaurante?user=postgres&password=M@caco1234");
        try {
            model.addAttribute("usuarios", userQueryMaker.getAllUsersQuery());
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

        return "teste";
    }
}
