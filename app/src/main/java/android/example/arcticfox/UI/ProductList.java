package android.example.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.example.arcticfox.Database.Repository;
import android.example.arcticfox.Entity.Product;
import android.view.Menu;
import android.example.arcticfox.R;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repo = new Repository(getApplication());
        List<Product> products = repo.getAllProducts();
        final ProductAdapter adapter = new ProductAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setProducts(products);
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




