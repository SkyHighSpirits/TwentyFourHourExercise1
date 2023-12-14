package com.example.twentyfourhourexercise1.repository;

import com.example.twentyfourhourexercise1.model.Delivery;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
