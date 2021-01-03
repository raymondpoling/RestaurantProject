package org.mousehole.restaurantproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.mousehole.restaurantproject.R;
import org.mousehole.restaurantproject.model.RestaurantData;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int RESTAURANT_DATA = 2112;

    private Button updateButton;

    private TextView addressTextView, phoneTextView, nameTextView, descriptionTextView, menuTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindings
        updateButton = findViewById(R.id.update_button);

        addressTextView = findViewById(R.id.address_textview);
        phoneTextView = findViewById(R.id.phone_textview);
        nameTextView = findViewById(R.id.name_textview);
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
            RestaurantData restaurantData =  (RestaurantData) Objects.requireNonNull(data).getSerializableExtra(DetailsActivity.RESTAURANT_DATA);
            if(restaurantData == null) {
                updateView(RestaurantData.getDefaultRestaurantData(this));
            } else {
                updateView(restaurantData);
            }
        }
    }

    private void updateView(RestaurantData restaurantData) {
        addressTextView.setText(restaurantData.getAddress());
        phoneTextView.setText(restaurantData.getPhone());
        nameTextView.setText(restaurantData.getName());
        descriptionTextView.setText(restaurantData.getDescription());
        menuTextView.setText(restaurantData.getMenu());
    }
}