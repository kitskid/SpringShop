package com.example.securityapplication.controllers;

import com.example.securityapplication.models.Person;
import com.example.securityapplication.services.PersonRegistrationService;
import com.example.securityapplication.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    private final PersonValidator personValidator;
    private final PersonRegistrationService personRegistrationService;

    @Autowired
    public AuthenticationController(PersonValidator personValidator, PersonRegistrationService personRegistrationService) {
        this.personValidator = personValidator;
        this.personRegistrationService = personRegistrationService;
    }


    @GetMapping("/login")
    public String login(){
        return "authentication/login";
    }
    @GetMapping("/registration")
    public String registration(@ModelAttribute("person") Person person){
       return "registration/registration";
    }
    @PostMapping("/registration")
    public String resultRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println("Нашли ошибки: " + bindingResult.getAllErrors());
            return "registration/registration";
        }
        personRegistrationService.register(person);
        return "redirect:/index";
    }
}
