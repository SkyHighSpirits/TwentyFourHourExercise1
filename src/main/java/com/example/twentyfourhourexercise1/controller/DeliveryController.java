package com.example.twentyfourhourexercise1.controller;

import com.example.twentyfourhourexercise1.model.Delivery;
import com.example.twentyfourhourexercise1.model.ProductOrder;
import com.example.twentyfourhourexercise1.repository.DeliveryRepository;
import com.example.twentyfourhourexercise1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    OrderRepository orderRepository;



    @GetMapping("/getDeliveryById")
    public ResponseEntity<Delivery> getDeliveryByID(@RequestParam int id)
    {
        try {
            Optional<Delivery> checkDelivery = deliveryRepository.findById(id);
            if(checkDelivery.isPresent())
            {
                Delivery delivery = checkDelivery.get();
                return ResponseEntity.ok(delivery);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAllDeliveries")
    public ResponseEntity<List<Delivery>> getAllDeliveries()
    {
        try {
            Optional<List<Delivery>> checkDeliveries = Optional.of(deliveryRepository.findAll());
            if(checkDeliveries.isPresent())
            {
                List<Delivery> delivery = checkDeliveries.get();
                return ResponseEntity.ok(delivery);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/adddelivery")
    public ResponseEntity<String> addDelivery(@RequestParam LocalDate deliverydate, @RequestParam String destination) {
        try
        {
            Delivery delivery = new Delivery();
            delivery.setDeliveryDate(deliverydate);
            delivery.setDestination(destination);

            deliveryRepository.save(delivery);
            return ResponseEntity.ok("Delivery Successfully added");
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addProductOrderToDelivery")
    public ResponseEntity<String> addProductOrderToDelivery(@RequestParam int deliveryId, @RequestBody ProductOrder productOrder)
    {

        try {
            Optional<Delivery> delivery = deliveryRepository.findById(deliveryId);

            if (delivery.isPresent()) {

                Delivery deliveryObject = delivery.get();
                productOrder.setDelivery(deliveryObject);
                List<ProductOrder> orders = deliveryObject.getOrders();
                orders.add(productOrder);
                deliveryObject.setOrders(orders);
                deliveryRepository.save(deliveryObject);
                return ResponseEntity.ok("Product Order saved succesfully");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
