package org.mousehole.restaurantproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.mousehole.restaurantproject.R;
import org.mousehole.restaurantproject.model.RestaurantData;

public class DetailsActivity extends AppCompatActivity {

    public static final String RESTAURANT_DATA = "Restaurant Data";

    private Button saveButton;

    private EditText nameEditText, descriptionEditText, phoneEditText, addressEditText, menuEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //bindings
        nameEditText = findViewById(R.id.name_edittext);
        descriptionEditText = findViewById(R.id.description_editview);
        phoneEditText = findViewById(R.id.phone_editview);
        addressEditText = findViewById(R.id.address_editview);
        menuEditText = findViewById(R.id.menu_edittext);

        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(v -> {
            RestaurantData restaurantData = buildRestaurantData();
            Intent intent = new Intent();
            intent.putExtra(RESTAURANT_DATA, restaurantData);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private RestaurantData buildRestaurantData() {
        return new RestaurantData(nameEditText.getText().toString(),
                addressEditText.getText().toString(),
                phoneEditText.getText().toString(),
                descriptionEditText.getText().toString(),
                menuEditText.getText().toString());
    }
}