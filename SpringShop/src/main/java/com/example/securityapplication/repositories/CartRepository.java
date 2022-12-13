package com.example.securityapplication.repositories;

import com.example.securityapplication.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByPersonId(int id);

    void deleteCartByProductId(int id);
}