package com.example.iap_project;

import java.util.ArrayList;

public class Cart {

    private int id;
     ArrayList<Product> items;
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
}
