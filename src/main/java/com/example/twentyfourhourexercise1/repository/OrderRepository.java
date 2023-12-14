package com.example.twentyfourhourexercise1.repository;

import com.example.twentyfourhourexercise1.model.ProductOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductOrder, Integer> {

}
