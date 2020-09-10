package com.example.iap_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;


public class VendorDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private ArrayList<Product> mProductsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_detail);

        ImageView vendorPicture = findViewById(R.id.imageView);
        vendorPicture.setImageResource(R.drawable.dummy_image);

        mRecyclerView = findViewById(R.id.product_recycler_view);
        mProductsData = new ArrayList<>();
        mProductAdapter = new ProductAdapter(mProductsData, this);
        mRecyclerView.setAdapter(mProductAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeData();

    }

    private void initializeData() {
        TypedArray vendorImages = getResources().obtainTypedArray(R.array.vendor_icons);

        mProductsData.clear();

        Product product = new Product(1, "Soap", vendorImages.getResourceId(0, 0),
                "Washes white", 300, 400, 1);

        mProductsData.add(product);

        vendorImages.recycle();
        mProductAdapter.notifyDataSetChanged();
    }

}
