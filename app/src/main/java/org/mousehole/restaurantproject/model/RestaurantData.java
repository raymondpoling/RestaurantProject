package org.mousehole.restaurantproject.model;

import android.content.Context;

import org.mousehole.restaurantproject.R;

import java.io.Serializable;

public class RestaurantData implements Serializable {

    private String name;
    private String address;
    private String phone;
    private String description;
    private String menu;

    public RestaurantData(String name, String address, String phone, String description, String menu) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public static RestaurantData getDefaultRestaurantData(Context context) {
        return new RestaurantData(context.getResources().getString(R.string.name),
                context.getResources().getString(R.string.address),
                context.getResources().getString(R.string.phone),
                context.getResources().getString(R.string.description),
                context.getResources().getString(R.string.menu_items));
    }
}

