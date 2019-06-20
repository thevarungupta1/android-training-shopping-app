package com.example.shoppingapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingapp.R;
import com.example.shoppingapp.models.Product;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.MyViewHolder> {

    Context mContext;
    ArrayList<Product> mList = new ArrayList<>();

    public AdapterProducts(Context context, ArrayList<Product> list){
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_product, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Product product = mList.get(i);
        Toast.makeText(mContext, ""+product.getName(), Toast.LENGTH_SHORT).show();
        myViewHolder.textViewName.setText(product.getName());
        myViewHolder.textViewUnit.setText(product.getUnit());
        myViewHolder.textViewPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(ArrayList<Product> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName, textViewUnit, textViewPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_product_name);
            textViewUnit = itemView.findViewById(R.id.text_view_product_unit);
            textViewPrice = itemView.findViewById(R.id.text_view_product_price);
        }
    }
}
