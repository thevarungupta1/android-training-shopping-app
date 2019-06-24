package com.example.shoppingapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    public static final String KEY_PRODUCT = "product";

    String name, unit, image;
    int quantity;
    int price;
    int id;


    public Product(){}

    public Product(String name, String unit, int price, String image) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.image = image;
    }

    public Product(String name, String unit, String image, int quantity, int price, int id) {
        this.name = name;
        this.unit = unit;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public static String getKeyProduct() {
        return KEY_PRODUCT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
