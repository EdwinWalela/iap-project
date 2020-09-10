package com.example.iap_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class VendorActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    private ArrayList<Vendor> mVendorData;
    private VendorAdapter mVendorAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);


        mRecyclerView = findViewById(R.id.vendor_recycler_view);
        mVendorData = new ArrayList<>();
        mVendorAdapter = new VendorAdapter(mVendorData, this);
        mRecyclerView.setAdapter(mVendorAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initializeVendorData();


    }

    private void initializeVendorData() {
        String [] vendorNames = getResources().getStringArray(R.array.vendor_names);
        TypedArray vendorIcons = getResources().obtainTypedArray(R.array.vendor_icons);
        TypedArray vendorImages = getResources().obtainTypedArray(R.array.vendor_image);
        String [] vendorLocation = getResources().getStringArray(R.array.vendor_location);
        //String [] vendorId = getResources().getStringArray(R.array.vendor_id);
        String [] vendorContact = getResources().getStringArray(R.array.vendor_contact);
        String [] vendorLatitude = getResources().getStringArray(R.array.vendor_latitude);
        String [] vendorLongitude = getResources().getStringArray(R.array.vendor_longitude);

        mVendorData.clear();

        for (int i = 0; i < vendorNames.length; i++){
            Vendor vendor = new Vendor(vendorNames[i], vendorIcons.getResourceId(i, 0),
                    vendorImages.getResourceId(i, 0), vendorLocation[i], 1,
                    vendorContact[i], vendorLatitude[i], vendorLongitude[i]);

            mVendorData.add(vendor);
        }

        vendorIcons.recycle();
        vendorImages.recycle();
        mVendorAdapter.notifyDataSetChanged();

    }
}
