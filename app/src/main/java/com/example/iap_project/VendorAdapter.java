package com.example.iap_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder> {

    private ArrayList<Vendor> vendor_list;
    private Context mContext;

    public static final String KEY_NAME = "name";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_ID = "id";

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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Vendor vendor = vendor_list.get(position);
        holder.vendorName.setText(vendor.getVendor_name());
        holder.vendorLocation.setText(vendor.getVendor_location());
        Glide.with(mContext).load(R.drawable.vendor_logo).into(holder.vendorIcon);

        holder.mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vendor vendor1 = vendor_list.get(position);

                Intent intent = new Intent(v.getContext(), VendorDetailActivity.class);

                //intent.putExtra(KEY_NAME, vendor.getVendor_name());
                //intent.putExtra(KEY_LOCATION, vendor.getVendor_location());
                //intent.putExtra(KEY_ID, vendor.getVendor_id());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vendor_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView vendorIcon;
        public TextView vendorName;
        public TextView vendorLocation;
        public ConstraintLayout mConstraintLayout;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            vendorIcon = itemView.findViewById(R.id.vendor_image_logo);
            vendorName = itemView.findViewById(R.id.vendor_name);
            vendorLocation = itemView.findViewById(R.id.vendor_description);
            mConstraintLayout = itemView.findViewById(R.id.constraintLayout);


        }
    }
}
