package com.example.shoppingapp.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shoppingapp.R;
import com.example.shoppingapp.database.DBHelper;
import com.example.shoppingapp.models.Product;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;

    Toolbar toolbar;
    ImageView imageView;
    TextView textViewProductName, textViewProductUnit, textViewProductPrice;
    Button buttonAddToCart, buttonBuyNow;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        dbHelper = new DBHelper(this);

        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        imageView = findViewById(R.id.image_view);
        textViewProductName = findViewById(R.id.text_view_product_name);
        textViewProductUnit = findViewById(R.id.text_view_product_unit);
        textViewProductPrice = findViewById(R.id.text_view_product_price);
        buttonAddToCart = findViewById(R.id.button_add_to_cart);
        buttonBuyNow = findViewById(R.id.button_buy_now);
        buttonAddToCart.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent!=null){
            product = (Product) getIntent().getSerializableExtra(Product.KEY_PRODUCT);
            textViewProductPrice.setText(product.getName());
            textViewProductUnit.setText(product.getUnit());
            textViewProductPrice.setText(String.valueOf(product.getPrice()));
            Glide.with(this).load(product.getImage()).into(imageView);

            toolbar.setTitle(product.getName());
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "Search is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_cart:
                startActivity(new Intent(this, CartActivity.class));
                break;
            case R.id.menu_profile:
                Toast.makeText(this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_login:
                Toast.makeText(this, "Login is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_to_cart:
                dbHelper.addToCart(product);
                Toast.makeText(this, "Product added to cart successfully", Toast.LENGTH_SHORT).show();
                break;

        }
    }

}
