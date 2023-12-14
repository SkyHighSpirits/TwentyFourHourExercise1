package com.example.twentyfourhourexercise1.model;

import jakarta.persistence.*;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private float price;

    private int weight;

    public Product(int id, String name, float price, int weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product()
    {

    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productorder_id")
    private ProductOrder productOrder;

    public ProductOrder getOrder() {
        return productOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public void setOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }
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
