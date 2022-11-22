package com.example.securityapplication.controllers;

import com.example.securityapplication.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index(){

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

//        System.out.println("ID пользователя" + personDetails.getPerson().getId());
//        System.out.println("Логин пользователя" + personDetails.getPerson().getLogin());
//        System.out.println("Пароль пользователя" + personDetails.getPerson().getPassword());
       // RestController restController = new RestController();
       // restController.requestMethod();
        return "index";
    }
    @GetMapping("/main")
    public String one(){
        System.out.println("Привет! Все работает!");

        return "main";
    }
}
