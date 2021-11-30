package com.techiemaster.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private String category;
    private int price;
    private int quantity;
    private String image;
    private String images;
    private String description;

    public Product(int id, String name, String category, int price, int quantity, String image,String description,String images) {
        Id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.images = images;
        this.description = description;
    }
}
