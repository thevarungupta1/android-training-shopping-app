package com.example.shoppingapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoppingapp.R;
import com.example.shoppingapp.models.Image;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ViewHolder> {

    Context context;
    ArrayList<Image> list = new ArrayList<>();
    LayoutInflater layoutInflater;

    public AdapterTest(Context context, ArrayList<Image> list){
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Image> list){
        list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.row_adapter_test, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Image image = list.get(i);
        viewHolder.textView.setText(image.getTitle());
        Log.d("test", image.getImage());
        //Glide.with(context).load(image.getImage()).error(R.drawable.ic_add_black_24dp).placeholder(R.drawable.ic_add_black_24dp).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView  = itemView.findViewById(R.id.text_view);
        }
    }
}
