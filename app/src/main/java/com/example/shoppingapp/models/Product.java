package com.example.shoppingapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    public static final String KEY_PRODUCT = "product";

    String name, unit, price, image;


    public Product(){}

    public Product(String name, String unit, String price, String image) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
