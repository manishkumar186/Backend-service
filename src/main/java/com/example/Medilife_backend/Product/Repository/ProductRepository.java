package com.example.Medilife_backend.Product.Repository;

import com.example.Medilife_backend.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategoryName(String categoryName);

    List<Product> findByProductName(String productName);
}
