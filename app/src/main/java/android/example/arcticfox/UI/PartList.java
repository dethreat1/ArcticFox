package android.example.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.example.arcticfox.R;
import android.os.Bundle;
import android.widget.EditText;

public class PartList extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    String name;
    Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        editName = findViewById(R.id.editProductName);
        editPrice = findViewById(R.id.editProductPrice);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", -1);
        editName.setText(name);
        editPrice.setText(Double.toString(price));

    }
}