package com.example.iap_project;

public class Vendor {
    private String vendor_name;
    private int vendor_icon;
    private int vendor_image;
    private String vendor_location;
    private int vendor_id;
    private String vendor_contact;
    private String vendor_latitude;
    private String vendor_longitude;

    public Vendor(String vendor_name, int vendor_icon, int vendor_image,
                  String vendor_location, int vendor_id, String vendor_contact,
                  String vendor_latitude, String vendor_longitude)
    {
        this.vendor_name = vendor_name;
        this.vendor_icon = vendor_icon;
        this.vendor_image = vendor_image;
        this.vendor_location = vendor_location;
        this.vendor_id = vendor_id;
        this.vendor_contact = vendor_contact;
        this.vendor_latitude = vendor_latitude;
        this.vendor_longitude = vendor_longitude;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public int getVendor_icon() {
        return vendor_icon;
    }

    public void setVendor_icon(int vendor_icon) {
        this.vendor_icon = vendor_icon;
    }

    public int getVendor_image() {
        return vendor_image;
    }

    public void setVendor_image(int vendor_image) {
        this.vendor_image = vendor_image;
    }

    public String getVendor_location() {
        return vendor_location;
    }

    public void setVendor_location(String vendor_location) {
        this.vendor_location = vendor_location;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_contact() {
        return vendor_contact;
    }

    public void setVendor_contact(String vendor_contact) {
        this.vendor_contact = vendor_contact;
    }

    public String getVendor_latitude() {
        return vendor_latitude;
    }

    public void setVendor_latitude(String vendor_latitude) {
        this.vendor_latitude = vendor_latitude;
    }

    public String getVendor_longitude() {
        return vendor_longitude;
    }

    public void setVendor_longitude(String vendor_longitude) {
        this.vendor_longitude = vendor_longitude;
    }
}
