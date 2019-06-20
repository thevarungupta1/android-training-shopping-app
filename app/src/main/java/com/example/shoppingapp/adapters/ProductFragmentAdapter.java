package com.example.shoppingapp.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.shoppingapp.fragments.ProductFragment;

import java.util.ArrayList;

public class ProductFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragment = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();

    public ProductFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    public void addFragment(String title){
        mFragment.add(ProductFragment.newInstance(title));
        mTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
