package com.dangminhdang.review01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dangminhdang.review01.adapter.ProductAdapter;

import java.util.ArrayList;

public class ListOfProduct extends AppCompatActivity {

    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_of_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnAddProduct), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnAddProduct = findViewById(R.id.btnAddProduct);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProduct.this, AddProduct.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProduct.this, About.class);
                startActivity(intent);
            }
        });

        products = new ArrayList<>();
        products.add(new Product(1, "P001", "Bluetooth Speaker", 25.99,
                "https://th.bing.com/th/id/OIP.P2-VvoieEgA0-3ZXJ41eCAHaLT?rs=1&pid=ImgDetMain"));
        products.add(new Product(2, "P002", "Smart Watch", 55.49,
                "https://m.media-amazon.com/images/I/71mTOO-TKUL._AC_SL1500_.jpg"));
        products.add(new Product(3, "P003", "LED Desk Lamp", 18.75,
                "https://cdn.shopify.com/s/files/1/0273/0351/0069/products/taotronics-desk-lamp-with-4-lighting-modes-dl01-gallery-7.jpg?v=1584070116"));
        products.add(new Product(4, "P004", "Wireless Mouse", 12.99,
                "https://th.bing.com/th/id/OIP.sBfF-G8eNG_AUGD3VelQOgHaHa?rs=1&pid=ImgDetMain"));
        products.add(new Product(5, "P005", "USB-C Hub", 34.50,
                "https://th.bing.com/th/id/OIP.fgc8COO8suySEUqrNtbZfwHaHi?rs=1&pid=ImgDetMain"));
        products.add(new Product(6, "P006", "Mechanical Keyboard", 79.99,
                "https://th.bing.com/th/id/OIP.HRziVdyzO9c2RIcvi7WouwHaEK?w=298&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        products.add(new Product(7, "P007", "Noise Cancelling Headphones", 129.00,
                "https://th.bing.com/th/id/OIP.7poMoN1zv9s4ol0iEt0DoAHaHa?w=187&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7"));


        ListView listView = findViewById(R.id.productListView);
        adapter = new ProductAdapter(this, R.layout.product_item, products);
        listView.setAdapter(adapter);

// Add button listener
        Button btnAdd = findViewById(R.id.btnAdd); // "Add Product" button
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfProduct.this, AddProduct.class);
            startActivityForResult(intent, 1); // requestCode = 1
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int id = data.getIntExtra("id", 0);
            String code = data.getStringExtra("code");
            String name = data.getStringExtra("name");
            double price = data.getDoubleExtra("price", 0.0);

            // Add to memory with default image
            products.add(new Product(id, code, name, price, "https://via.placeholder.com/150"));
            adapter.notifyDataSetChanged(); // refresh ListView
        }
    }

}