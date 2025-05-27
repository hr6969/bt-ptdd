package com.dangminhdang.k22411canewsample;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ProductManagementActivity extends AppCompatActivity {
    Spinner spinnerCategory;
    ArrayAdapter<Category>
    private ListView listView;
    private List<product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);

        listView = findViewById(R.id.listView);
        productList = generateDummyProducts();

        ProductAdapter adapter = new ProductAdapter(this, R.layout.item_product); // Your custom layout
        adapter.addAll(productList); // Add list to adapter
        listView.setAdapter(adapter);
    }

    private List<Product> generateDummyProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Wireless Mouse", 50, 159000, 1, R.drawable.mouse));
        products.add(new Product(2, "Bluetooth Keyboard", 30, 224900, 1, R.drawable.keyboard));
        products.add(new Product(3, "USB-C Charger", 40, 129000, 2, R.drawable.charger));
        products.add(new Product(4, "Laptop Stand", 20, 349500, 3, R.drawable.stand));
        products.add(new Product(5, "HDMI Cable", 100, 54900, 2, R.drawable.hdmi));
        products.add(new Product(6, "LED Desk Lamp", 25, 199000, 4, R.drawable.lamp));
        products.add(new Product(7, "Notebook Cooler", 18, 299000, 3, R.drawable.cooler));
        products.add(new Product(8, "Wireless Earbuds", 35, 599000, 5, R.drawable.earbuds));
        products.add(new Product(9, "Power Bank", 40, 249000, 2, R.drawable.powerbank));
        products.add(new Product(10, "Webcam 1080p", 22, 399000, 5, R.drawable.webcam));
        return products;
    }
    listView.setOnItemClickListener((parent, view, position, id) -> {
        Product selected = productList.get(position);
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("product", selected);
        startActivity(intent);
    });

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtAdvancedProduct), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void displayProductByCategory(Category c){
        adapterProduct.clear();
        adapterProduct.addAll(c.getProducts());
    }
    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(ProductManagementActivity.this, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory = new ListCategory();
        listCategory.generate_product_dataset();
        adapterCategory.addAll(listCategory.getCategories());

        lvProduct = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(ProductManagementActivity.this, android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.product_menu, menu);
    return true;
}

private PopupMenu getMenuInflater() {
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.menu_refresh) {
        Toast.makeText(this, "Refreshing product list...", Toast.LENGTH_SHORT).show();
        return true;
    } else if (id == R.id.menu_about) {
        Toast.makeText(this, "Product Manager App v1.0", Toast.LENGTH_SHORT).show();
        return true;
    }
    return super.onOptionsItemSelected(item);
}

}