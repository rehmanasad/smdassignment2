import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assign2.R;
import com.example.assign2.Restaurant;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameEditText, locationEditText, phoneEditText, descriptionEditText;
    private Button saveButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        nameEditText = findViewById(R.id.name_edit_text);
        locationEditText = findViewById(R.id.location_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);
        saveButton = findViewById(R.id.save_button);

        sharedPreferences = getSharedPreferences("Restaurants", MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRestaurant();
            }
        });
    }

    private void saveRestaurant() {
        String name = nameEditText.getText().toString();
        String location = locationEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        Restaurant newRestaurant = new Restaurant(name, location, phone, description);
        saveToSharedPreferences(newRestaurant);
    }

    private void saveToSharedPreferences(Restaurant newRestaurant) {
        // Get the current list of restaurants, add the new one, and save it back
        String restaurantsJson = sharedPreferences.getString("restaurantList", "[]");
        Arraylist listType = new ArrayList<Restaurant>();
        ArrayList<Restaurant> restaurantList = new Gson().fromJson(restaurantsJson, listType);

        restaurantList.add(newRestaurant);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("restaurantList", new Gson().toJson(restaurantList));
        editor.apply();

        // Confirm the save and close the activity
        Toast.makeText(this, "Restaurant saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}