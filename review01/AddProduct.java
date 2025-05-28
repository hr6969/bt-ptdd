package com.dangminhdang.review01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProduct extends AppCompatActivity {
    EditText edtProductID, edtProductCode, edtProductName, edtPrice;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        edtProductID = findViewById(R.id.edtProductID);
        edtProductCode = findViewById(R.id.edtProductCode);
        edtProductName = findViewById(R.id.edtProductName);
        edtPrice = findViewById(R.id.editTextNumberDecimal);
        btnAdd = findViewById(R.id.btn_AddProduct);

        btnAdd.setOnClickListener(v -> {
            int id = Integer.parseInt(edtProductID.getText().toString());
            String code = edtProductCode.getText().toString();
            String name = edtProductName.getText().toString();
            double price = Double.parseDouble(edtPrice.getText().toString());

            Intent intent = new Intent();
            intent.putExtra("id", id);
            intent.putExtra("code", code);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
    private void tryAutoSave() {
        String idStr = edtProductID.getText().toString().trim();
        String code = edtProductCode.getText().toString().trim();
        String name = edtProductName.getText().toString().trim();
        String priceStr = edtPrice.getText().toString().trim();

        // Only save if all fields are filled
        if (!idStr.isEmpty() && !code.isEmpty() && !name.isEmpty() && !priceStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                double price = Double.parseDouble(priceStr);

                Intent intent = new Intent();
                intent.putExtra("id", id);
                intent.putExtra("code", code);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                setResult(RESULT_OK, intent);
            } catch (NumberFormatException e) {
                // Ignore invalid input silently
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        tryAutoSave();
    }


}
