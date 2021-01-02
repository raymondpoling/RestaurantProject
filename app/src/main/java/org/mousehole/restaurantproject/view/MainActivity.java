package org.mousehole.restaurantproject.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mousehole.restaurantproject.R;
import org.mousehole.restaurantproject.model.RestaurantData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int RESTAURANT_DATA = 2112;

    private Button updateButton;

    private TextView addressTextview, phoneTextview, nameTextview, descriptionTextView, menuTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindings
        updateButton = findViewById(R.id.update_button);

        addressTextview = findViewById(R.id.address_textview);
        phoneTextview = findViewById(R.id.phone_textview);
        nameTextview = findViewById(R.id.name_textview);
        descriptionTextView = findViewById(R.id.description_textview);
        menuTextView = findViewById(R.id.menu_textview);

        updateButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivityForResult(intent, RESTAURANT_DATA);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESTAURANT_DATA) {
            RestaurantData restaurantData = (RestaurantData) data.getSerializableExtra(DetailsActivity.RESTAURANT_DATA);
            updateView(restaurantData);
        }
    }

    private void updateView(RestaurantData restaurantData) {
        addressTextview.setText(restaurantData.getAddress());
        phoneTextview.setText(restaurantData.getPhone());
        nameTextview.setText(restaurantData.getName());
        descriptionTextView.setText(restaurantData.getDescription());
        menuTextView.setText(restaurantData.getMenu());
    }
}