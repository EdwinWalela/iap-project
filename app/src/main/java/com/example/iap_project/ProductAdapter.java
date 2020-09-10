package com.example.iap_project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> product_list;
    private Context mContext;
    public Cart mCart;
    //private int mIndexPosition;

    public ProductAdapter(ArrayList<Product> product_list, Context context, Cart cart) {
        this.product_list = product_list;
        mContext = context;
        this.mCart = cart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_product_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Product product = product_list.get(position);
        Glide.with(mContext).load(product.getProduct_photo()).into(holder.productImage);
        holder.productName.setText(product.getProduct_name());
        holder.productPrice.setText("ksh: 300");

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfExistsProduct(product)){

                    ArrayList<Product> products = mCart.getItems();
                    int indexPosition = mCart.getItems().indexOf(product);
                    int quantity = products.get(indexPosition).getProduct_quantity() + 1;
                    products.get(indexPosition).setProduct_quantity(quantity);
                    mCart.setItems(products);
                    int newProductQuantity = mCart.getItems().get(indexPosition).getProduct_quantity();
                    holder.productQuantity.setText(Integer.toString(newProductQuantity));

                }
                else{

                    ArrayList<Product> products = mCart.getItems();
                    products.add(product);
                    int IndexPosition = products.indexOf(product);
                    products.get(IndexPosition).setProduct_quantity(1);
                    mCart.setItems(products);
                    holder.productQuantity.setVisibility(View.VISIBLE);
                    int newProductQuantity = mCart.getItems().get(IndexPosition).getProduct_quantity();
                    holder.productQuantity.setText(Integer.toString(newProductQuantity));

                }

            }


        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfExistsProduct(product)){

                    int indexPosition = mCart.getItems().indexOf(product);
                    int currentQuantity = mCart.getItems().get(indexPosition).getProduct_quantity();

                    if (currentQuantity == 1){
                        holder.productQuantity.setText(Integer.toString(currentQuantity - 1));
                        mCart.getItems().remove(product);
                        holder.productQuantity.setVisibility(View.INVISIBLE);

                    } else {

                        mCart.getItems().get(indexPosition).setProduct_quantity(currentQuantity - 1);
                        int newQuantity = mCart.getItems().get(indexPosition).getProduct_quantity();
                        holder.productQuantity.setText(Integer.toString(newQuantity));
                        Toast.makeText(mContext, "This item is still in the cart", Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(mContext, "This product is not in the Cart", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    public boolean checkIfExistsProduct(Product product){
        if (mCart.items.contains(product)){
            return true;
        }
        return false;
    }


    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public ImageButton addButton;
        public ImageButton removeButton;
        public TextView productQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image_logo);
            productName =  itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            addButton = itemView.findViewById(R.id.btn_add_to_cart);
            removeButton = itemView.findViewById(R.id.btn_remove_from_cart);
            productQuantity = itemView.findViewById(R.id.quantity);

        }


    }
}
