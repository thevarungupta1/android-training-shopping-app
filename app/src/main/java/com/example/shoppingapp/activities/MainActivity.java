package com.example.shoppingapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shoppingapp.R;
import com.example.shoppingapp.adapters.ProductFragmentAdapter;
import com.example.shoppingapp.fragments.ProductFragment;
import com.example.shoppingapp.models.Product;
import com.example.shoppingapp.models.SampleData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
    }

    private void init() {
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








}
