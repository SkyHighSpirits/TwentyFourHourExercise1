package com.example.twentyfourhourexercise1.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate deliveryDate;

    private String destination;

    public Delivery(int id, LocalDate deliveryDate, String destination, List<ProductOrder> productOrders) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.destination = destination;
        this.productOrders = productOrders;
    }

    @OneToMany(mappedBy = "delivery")
    List<ProductOrder> productOrders;

    public Delivery()
    {

    }

    public List<ProductOrder> getOrders() {
        return productOrders;
    }

    public void setOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
