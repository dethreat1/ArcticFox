package android.example.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.example.arcticfox.R;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_productlist, menu);
        return true;
    }

    public boolean onOptionsMenuSelected(MenuItem item) {
        switch ((item.getItemId())) {
            case android.R.id.home:
                this.finish(); //maintains the state
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToPartsList(View view) {
        Intent intent = new Intent(ProductList.this, PartList.class);
        startActivity(intent);
    }
}




