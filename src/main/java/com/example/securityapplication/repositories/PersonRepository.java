package com.example.securityapplication.repositories;

import com.example.securityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByLogin(String login);
}
