package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "code") // Make code column the primary key
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "price")
    private double price;

    @Column(name = "in_date")
    @CreationTimestamp
    private Date inDate;

    public Product() {
        // Default constructor
    }

    public Product(String code, String name, String productType, double price, Date inDate) {
        this.code = code;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.inDate = inDate;
    }

    // Getters and setters for other attributes

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
