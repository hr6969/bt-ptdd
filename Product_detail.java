package com.dangminhdang.k22411canewsample;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.dangminhdang.k22411canewsample.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imgProductDetail;
    TextView txtDetailId, txtDetailName, txtDetailQuantity, txtDetailPrice, txtDetailCateId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imgProductDetail = findViewById(R.id.imgProductDetail);
        txtDetailId = findViewById(R.id.txtDetailId);
        txtDetailName = findViewById(R.id.txtDetailName);
        txtDetailQuantity = findViewById(R.id.txtDetailQuantity);
        txtDetailPrice = findViewById(R.id.txtDetailPrice);
        txtDetailCateId = findViewById(R.id.txtDetailCateId);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            imgProductDetail.setImageResource(product.getImage_id());
            txtDetailId.setText("ID: " + product.getId());
            txtDetailName.setText("Name: " + product.getName());
            txtDetailQuantity.setText("Quantity: " + product.getQuantity());
            txtDetailPrice.setText("Price: " + product.getPrice() + " VND");
            txtDetailCateId.setText("Category ID: " + product.getCateid());
        }
    }

}
