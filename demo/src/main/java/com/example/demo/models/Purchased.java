package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
@Entity
@Table(name = "purchased")
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    private Product product;
    @Column
    private int quantity;
    @Column
    private double total;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    // Constructors, getters, and setters

    public Purchased(Long id, Product product, int quantity, double total, Date date) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

