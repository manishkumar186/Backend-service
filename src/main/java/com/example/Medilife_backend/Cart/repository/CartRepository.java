package com.example.Medilife_backend.Cart.repository;

import com.example.Medilife_backend.Cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {


    List<Cart> findByUserName(String userName);
}
