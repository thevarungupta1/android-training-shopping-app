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
            case LATOP:
                product = new Product("Apple Air", "1 pcs", 65000, "https://cdn.shopify.com/s/files/1/0259/1735/products/macbook_pro_template_f82fc930-8c1e-4924-bcdb-dcb11e4559eb_2048x.jpg?v=1559211883");
                list.add(product);
                product = new Product("Dell Laptop", "1 pcs", 54000, "https://cdn.shopify.com/s/files/1/0259/1735/products/macbook_pro_template_f82fc930-8c1e-4924-bcdb-dcb11e4559eb_2048x.jpg?v=1559211883");
                list.add(product);
                product = new Product("HP Laptop Air", "1 pcs", 50000, "https://cdn.shopify.com/s/files/1/0259/1735/products/macbook_pro_template_f82fc930-8c1e-4924-bcdb-dcb11e4559eb_2048x.jpg?v=1559211883");
                list.add(product);
                return list;
            case MOBILE:
                product = new Product("Samsung S10", "1 pcs", 60000, "https://www.91-img.com/pictures/127289-v4-samsung-galaxy-j2-core-mobile-phone-large-1.jpg");
                list.add(product);
                product = new Product("Nokia 5300", "1 pcs", 24000, "https://www.91-img.com/pictures/127289-v4-samsung-galaxy-j2-core-mobile-phone-large-1.jpg");
                list.add(product);
                product = new Product("MI6", "1 pcs", 20000, "https://www.91-img.com/pictures/127289-v4-samsung-galaxy-j2-core-mobile-phone-large-1.jpg");
                list.add(product);
                return list;
            case DESKTOP:
                product = new Product("Acer Desktop", "1 pcs", 33000, "https://5.imimg.com/data5/QG/CH/MY-33888924/dell-desktop-computer-500x500.jpg");
                list.add(product);
                product = new Product("Dell All-In-One", "1 pcs", 20000, "https://5.imimg.com/data5/QG/CH/MY-33888924/dell-desktop-computer-500x500.jpg");
                list.add(product);
                product = new Product("Apple Mac", "1 pcs", 28000, "https://5.imimg.com/data5/QG/CH/MY-33888924/dell-desktop-computer-500x500.jpg");
                list.add(product);
                return list;
            default:
                return null;
        }
    }

}
