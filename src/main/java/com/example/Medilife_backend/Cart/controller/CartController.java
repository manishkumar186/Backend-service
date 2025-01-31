package com.example.Medilife_backend.Cart.controller;


import com.example.Medilife_backend.Cart.entity.Cart;
import com.example.Medilife_backend.Cart.exception.ResourceNotFoundException;
import com.example.Medilife_backend.Cart.repository.CartRepository;
import com.example.Medilife_backend.Cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/medilife")
//@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }

    @GetMapping("/cartDetail")
    public List<Cart> getAllProductByUsingProductName(@RequestParam String userName){
        return cartService.getCartDetailByUserName(userName);
    }

    @DeleteMapping("/cartDetail/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCartDetail(@PathVariable Integer id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        cartRepository.delete(cart);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }




}
