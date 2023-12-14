package com.example.twentyfourhourexercise1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductOrder {

    public ProductOrder(int id, int quantity, List<Product> products, Delivery delivery) {
        this.id = id;
        this.quantity = quantity;
        this.products = products;
        this.delivery = delivery;
    }

    public ProductOrder()
    {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @OneToMany(mappedBy = "productOrder", orphanRemoval = true)
    private List<Product> products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
