package com.example.twentyfourhourexercise1.controller;

import com.example.twentyfourhourexercise1.model.Delivery;
import com.example.twentyfourhourexercise1.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@CrossOrigin
@Controller
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @PostMapping("/adddelivery")
    public ResponseEntity<String> addDelivery(@RequestParam LocalDate deliverydate, @RequestParam String destination) {
        try
        {
            Delivery delivery = new Delivery();
            delivery.setDeliveryDate(deliverydate);
            delivery.setDestination(destination);

            delivery.setOrders();

            deliveryRepository.save(delivery);
            return ResponseEntity.ok("Delivery Successfully added");
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
