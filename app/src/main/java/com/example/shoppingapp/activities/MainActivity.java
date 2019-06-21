package com.example.shoppingapp.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.adapters.ProductFragmentAdapter;
import com.example.shoppingapp.fragments.ProductFragment;
import com.example.shoppingapp.models.Product;
import com.example.shoppingapp.models.SampleData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        ProductFragmentAdapter adapter = new ProductFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(SampleData.MOBILE);
        adapter.addFragment(SampleData.LATOP);
        adapter.addFragment(SampleData.DESKTOP);

        viewPager.setAdapter(adapter);
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
}
