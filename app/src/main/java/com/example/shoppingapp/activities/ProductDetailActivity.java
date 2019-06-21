package com.example.shoppingapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoppingapp.R;
import com.example.shoppingapp.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewProductName, textViewProductUnit, textViewProductPrice;
    Button buttonAddToCart, buttonBuyNow;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        init();
    }

    private void init() {
        imageView = findViewById(R.id.image_view);
        textViewProductName = findViewById(R.id.text_view_product_name);
        textViewProductUnit = findViewById(R.id.text_view_product_unit);
        textViewProductPrice = findViewById(R.id.text_view_product_price);
        buttonAddToCart = findViewById(R.id.button_add_to_cart);
        buttonBuyNow = findViewById(R.id.button_buy_now);

        Intent intent = getIntent();
        if(intent!=null){
            product = (Product) getIntent().getSerializableExtra(Product.KEY_PRODUCT);
            textViewProductPrice.setText(product.getName());
            textViewProductUnit.setText(product.getUnit());
            textViewProductPrice.setText(product.getPrice());
            Glide.with(this).load(product.getImage()).into(imageView);
        }



    }
}
