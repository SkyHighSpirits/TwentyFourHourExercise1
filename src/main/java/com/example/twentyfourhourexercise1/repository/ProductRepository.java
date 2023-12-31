package com.example.twentyfourhourexercise1.repository;

import com.example.twentyfourhourexercise1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByName(String name);
}
