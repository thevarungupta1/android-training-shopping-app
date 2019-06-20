package com.example.shoppingapp.models;

import java.util.ArrayList;

public class SampleData {



    public static final String MOBILE = "mobile";
    public static final String LATOP = "laptop";
    public static final String DESKTOP = "desktop";

    public void getName(){

    }

    public static ArrayList<Product> getData(String title) {
        ArrayList<Product> list = new ArrayList<>();
        Product product;
        switch (title) {
            case MOBILE:
                product = new Product("Apple Laptop Air", "1 pcs", "40000");
                list.add(product);
                product = new Product("Dell Laptop", "1 pcs", "40000");
                list.add(product);
                product = new Product("HP Laptop Air", "1 pcs", "40000");
                list.add(product);
                return list;
            case LATOP:
                product = new Product("Samsung", "1 pcs", "40000");
                list.add(product);
                product = new Product("Nokia", "1 pcs", "40000");
                list.add(product);
                product = new Product("MI", "1 pcs", "40000");
                list.add(product);
                return list;
            case DESKTOP:
                product = new Product("Acer", "1 pcs", "40000");
                list.add(product);
                product = new Product("Dell", "1 pcs", "40000");
                list.add(product);
                product = new Product("Apple", "1 pcs", "40000");
                list.add(product);
                return list;
            default:
                return null;
        }
    }

}
