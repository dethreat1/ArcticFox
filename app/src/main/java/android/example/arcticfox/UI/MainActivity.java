package android.example.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.arcticfox.Database.Repository;
import android.example.arcticfox.Entity.Part;
import android.example.arcticfox.Entity.Product;
import android.example.arcticfox.R;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add line of code for git test
    }

    public void EnterHere(View view) {
        Intent intent = new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Product product = new Product(1, "unicycle", 10.0);
        repo.insert(product);
        Part part = new Part(1, "unicycle", 10, 1);
        repo.insert(part);
    }
}