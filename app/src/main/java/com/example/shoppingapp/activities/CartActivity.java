package com.example.shoppingapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.adapters.AdapterCart;
import com.example.shoppingapp.database.DBHelper;
import com.example.shoppingapp.models.Cart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements AdapterCart.ClickListener {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterCart adapterCart;
    ArrayList<Cart> mList = new ArrayList<>();

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dbHelper = new DBHelper(this);
        mList = dbHelper.getAllCart();

        setUpToolbar();
        init();

    }

    private void setUpToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void init(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        adapterCart = new AdapterCart(this, mList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapterCart);
        adapterCart.setClickListener(this);

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
    public void itemClicked(View v, int position) {
        Cart cart = mList.get(position);
        dbHelper.deleteFromCart(cart.getProductName());
        mList.remove(position);
        adapterCart.notifyDataSetChanged();
    }
}
