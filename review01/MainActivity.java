package com.example.yourapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.dangminhdang.review01.Account;
import com.dangminhdang.review01.Product;
import com.dangminhdang.review01.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Account> accounts;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this layout exists

        // Initialize accounts
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "john_doe", "password123"));
        accounts.add(new Account(2, "alice_smith", "alicepass"));
        accounts.add(new Account(3, "admin", "admin2025"));

        // Initialize products
        products = new ArrayList<>();
        products.add(new Product(1, "P001", "Bluetooth Speaker", 25.99,
                "https://th.bing.com/th/id/OIP.P2-VvoieEgA0-3ZXJ41eCAHaLT?rs=1&pid=ImgDetMain"));
        products.add(new Product(2, "P002", "Smart Watch", 55.49,
                "https://m.media-amazon.com/images/I/71mTOO-TKUL._AC_SL1500_.jpg"));
        products.add(new Product(3, "P003", "LED Desk Lamp", 18.75,
                "https://cdn.shopify.com/s/files/1/0273/0351/0069/products/taotronics-desk-lamp-with-4-lighting-modes-dl01-gallery-7.jpg?v=1584070116"));

    }
}
