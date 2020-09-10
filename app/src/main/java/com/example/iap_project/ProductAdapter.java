package com.example.iap_project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> product_list;
    private Context mContext;

    public ProductAdapter(ArrayList<Product> product_list, Context context) {
        this.product_list = product_list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_product_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = product_list.get(position);
        Glide.with(mContext).load(product.getProduct_photo()).into(holder.productImage);
        holder.productName.setText(product.getProduct_name());
        holder.productPrice.setText("ksh: 300");
    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image_logo);
            productName =  itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);

        }
    }
}
