package com.example.iap_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class VendorDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private ArrayList<Product> mProductsData;
    public Cart mCart;//declare a cart object
    public ArrayList<Product> mCartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_detail);

        //Intent intent = getIntent();
        //String storeName = intent.getStringExtra(VendorAdapter.KEY_NAME);
        //String storeLocation = intent.getStringExtra(VendorAdapter.KEY_LOCATION);
        //int storeId = intent.getIntExtra(VendorAdapter.KEY_ID, 0);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        ImageView vendorPicture = findViewById(R.id.imageView);
        vendorPicture.setImageResource(R.drawable.dummy_image);

        TextView storeTextView = findViewById(R.id.product_vendor_name);
        storeTextView.setText("Naivas");

        TextView storeLocationTextView = findViewById(R.id.product_vendor_location);
        storeLocationTextView.setText("freedom-heights");
        String stringId = Integer.toString(3);

        final String URL_DATA = "https://powerful-stream-03698.herokuapp.com/api/stores/" + stringId + "/products";

        //initialize the cart object
        mCartItems = new ArrayList<>();
        mCart = new Cart(0, mCartItems, 0,0, 0);

        mRecyclerView = findViewById(R.id.product_recycler_view);
        mProductsData = new ArrayList<>();
        //mProductAdapter = new ProductAdapter(mProductsData, this, mCart);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_view_cart:
                int quantity = mCart.getItems().get(1).getProduct_quantity();
                Toast.makeText(this, Integer.toString(quantity), Toast.LENGTH_LONG);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
