package com.example.iap_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VendorActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    private ArrayList<Vendor> mVendorData;
    private VendorAdapter mVendorAdapter;
    private static final String URL_DATA = "https://powerful-stream-03698.herokuapp.com/api/stores";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);




        mRecyclerView = findViewById(R.id.vendor_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mVendorData = new ArrayList<>();

        //mVendorAdapter = new VendorAdapter(mVendorData, this);
        //mRecyclerView.setAdapter(mVendorAdapter);



        initializeVendorData();


    }

    private void initializeVendorData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("res", "Response:" + response);
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("stores");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jo = array.getJSONObject(i);
                                Vendor vendor = new Vendor(jo.getString("name"),
                                        1,
                                        1,
                                        jo.getString("location"),
                                        jo.getInt("id"),
                                        jo.getString("contact"),
                                        jo.getString("latitude"),
                                        jo.getString("longitude"));

                                mVendorData.add(vendor);
                                Log.d("res", "vendors" + vendor);
                            }
                            mVendorAdapter = new VendorAdapter(mVendorData, getApplicationContext());
                            mRecyclerView.setAdapter(mVendorAdapter);
                            //mVendorAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("Tag", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VendorActivity.this, "Error " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }
}
