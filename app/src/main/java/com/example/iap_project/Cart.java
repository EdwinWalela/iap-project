package com.example.iap_project;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cart implements Parcelable {

    private int id;
    public ArrayList<Product> items;
    private int total_price;
    private int item_count;
    private int user_id;

    public Cart(int id, ArrayList<Product> items, int total_price, int item_count, int user_id) {
        this.id = id;
        this.items = items;
        this.total_price = total_price;
        this.item_count = item_count;
        this.user_id = user_id;
    }

    private Cart (Parcel parcel){
        id = parcel.readInt();
        items = new ArrayList<>();
        parcel.readTypedList(items, Product.CREATOR);
        total_price = parcel.readInt();
        item_count = parcel.readInt();
        user_id = parcel.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeList(items);
        dest.writeInt(total_price);
        dest.writeInt(item_count);
        dest.writeInt(user_id);

    }

    public static final Parcelable.Creator<Cart> CREATOR =
            new Parcelable.Creator<Cart>(){
                @Override
                public Cart createFromParcel(Parcel source) {
                    return new Cart(source);
                }

                @Override
                public Cart[] newArray(int size) {
                    return new Cart[size];
                }
            };
}
