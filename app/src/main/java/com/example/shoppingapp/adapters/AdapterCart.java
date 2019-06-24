package com.example.shoppingapp.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoppingapp.R;
import com.example.shoppingapp.models.Cart;
import com.example.shoppingapp.models.Product;

import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder> {

    private ClickListener clickListener;

    Context mContext;
    ArrayList<Cart> mList = new ArrayList<>();
    public  AdapterCart(Context context, ArrayList<Cart> list){
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_cart, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Cart cart = mList.get(i);
        viewHolder.textViewProductName.setText(cart.getProductName());
        Glide.with(mContext).load(cart.getProductImage()).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewProductName;
        ImageView imageView;
        Button buttonDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.text_view_product_name);
            imageView = itemView.findViewById(R.id.image_view);
            buttonDelete = itemView.findViewById(R.id.button_delete);
            buttonDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.itemClicked(v, getAdapterPosition());
        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        public void itemClicked(View v, int position);
    }
}
