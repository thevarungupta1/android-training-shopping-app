package com.example.shoppingapp.models;

import java.util.ArrayList;

public class Product {
    String name, unit, price;

    public Product(){}

    public Product(String name, String unit, String price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
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
