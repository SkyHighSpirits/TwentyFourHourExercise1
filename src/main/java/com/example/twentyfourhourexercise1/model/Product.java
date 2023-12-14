package com.example.twentyfourhourexercise1.model;

import jakarta.persistence.*;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float price;

    private int weight;

    public Product(int id, float price, int weight) {
        this.id = id;
        this.price = price;
        this.weight = weight;
    }

    public Product()
    {

    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
