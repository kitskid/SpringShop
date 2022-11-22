package com.example.securityapplication.util;

import com.example.securityapplication.models.Person;
import com.example.securityapplication.services.PersonRegistrationService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private PersonRegistrationService personRegistrationService;

    public PersonValidator(PersonRegistrationService personRegistrationService) {
        this.personRegistrationService = personRegistrationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person)target;

        if(personRegistrationService.findByLogin(person) != null){
            errors.rejectValue("login", "", "Данный логин уже занят");
        }
    }
}
