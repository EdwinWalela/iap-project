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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder> {

    private ArrayList<Vendor> vendor_list;
    private Context mContext;

    public VendorAdapter(ArrayList<Vendor> vendor_list, Context context) {
        this.vendor_list = vendor_list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_list_item,
                parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vendor vendor = vendor_list.get(position);
        holder.vendorName.setText(vendor.getVendor_name());
        holder.vendorLocation.setText(vendor.getVendor_location());
        Glide.with(mContext).load(vendor.getVendor_icon()).into(holder.vendorIcon);
    }

    @Override
    public int getItemCount() {
        return vendor_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView vendorIcon;
        public TextView vendorName;
        public TextView vendorLocation;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            vendorIcon = itemView.findViewById(R.id.vendor_image_logo);
            vendorName = itemView.findViewById(R.id.vendor_name);
            vendorLocation = itemView.findViewById(R.id.vendor_description);


        }
    }
}
