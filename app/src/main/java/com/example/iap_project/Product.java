package com.example.iap_project;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private int product_id;
    private String product_name;
    private int product_photo;
    private String product_description;
    private int product_price;
    private int product_stock;
    private int product_store_id;
    private int product_quantity;

    public Product(int product_id, String product_name, int product_photo,
                   String product_description, int product_price, int product_stock,
                   int product_store_id)
    {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_photo = product_photo;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_store_id = product_store_id;
    }

    private Product (Parcel parcel){
        product_id =  parcel.readInt();
        product_name = parcel.readString();
        product_photo = parcel.readInt();
        product_description = parcel.readString();
        product_price = parcel.readInt();
        product_stock = parcel.readInt();
        product_store_id = parcel.readInt();
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(int product_photo) {
        this.product_photo = product_photo;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    public int getProduct_store_id() {
        return product_store_id;
    }

    public void setProduct_store_id(int product_store_id) {
        this.product_store_id = product_store_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(product_id);
        dest.writeString(product_name);
        dest.writeInt(product_photo);
        dest.writeString(product_description);
        dest.writeInt(product_price);
        dest.writeInt(product_stock);
        dest.writeInt(product_store_id);

    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>(){
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
