package com.example.shoppingapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.adapters.AdapterProducts;
import com.example.shoppingapp.models.Product;
import com.example.shoppingapp.models.SampleData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    String catName;
    ArrayList<Product> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterProducts adapterProducts;


    public ProductFragment() {
        // Required empty public constructor
    }


    public static ProductFragment newInstance(String catName){
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString("cat", catName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        catName = getArguments().getString("cat");

        mList = SampleData.getData(catName);
        init(view);
        return view;
    }

    private void init(View view){
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapterProducts = new AdapterProducts(getActivity(), mList);
        mRecyclerView.setAdapter(adapterProducts);
        adapterProducts.setData(mList);
    }

}
