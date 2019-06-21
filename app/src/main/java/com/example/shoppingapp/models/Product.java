package com.example.shoppingapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    public static final String KEY_PRODUCT = "product";

    String name, unit, image;
    int price;


    public Product(){}

    public Product(String name, String unit, int price, String image) {
        this.name = name;
        this.unit = unit;
        this.image = image;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
