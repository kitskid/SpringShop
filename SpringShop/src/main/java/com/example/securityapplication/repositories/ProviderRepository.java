package com.example.securityapplication.repositories;


import com.example.securityapplication.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    Optional<Provider> findByLogin(String login);

    Optional<Provider> findProviderById(int id);
}
