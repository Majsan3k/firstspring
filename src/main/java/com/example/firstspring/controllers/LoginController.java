package com.example.firstspring.controllers;

import com.example.firstspring.models.LoginForm;
import com.example.firstspring.models.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(LoginForm loginForm){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.getErrorCount() > 0){
            System.out.println("We got errors!");
        }

        System.out.println("Username: " + loginForm.getUsername());
        System.out.println("Password: " + loginForm.getPassword());

        return "login";
    }
}
