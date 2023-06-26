package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "quantity")
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    private Product product;

    @Column
    private int quantity;

    @Column
    private String operation;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    public Quantity() {
        // Default constructor
    }

    public Quantity(Product product, int quantity, String operation, Date date) {
        this.product = product;
        this.quantity = quantity;
        this.operation = operation;
        this.date = date;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
