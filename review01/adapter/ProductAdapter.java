package com.dangminhdang.review01.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.bumptech.glide.Glide; // or use Picasso
import com.dangminhdang.review01.Product;
import com.dangminhdang.review01.R;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    ArrayList<Product> products;

    public ProductAdapter(Activity context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.context = context;
        this.resource = resource;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(resource, null);

        ImageView img = view.findViewById(R.id.productImage);
        TextView name = view.findViewById(R.id.productName);
        TextView code = view.findViewById(R.id.productCode);
        TextView price = view.findViewById(R.id.unitPrice);

        Product p = products.get(position);
        name.setText(p.getProductName());
        code.setText("Code: " + p.getProductCode());
        price.setText("Price: $" + p.getUnitPrice());

        Picasso.get().load(p.getImageLink())
                .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                .error(android.R.drawable.stat_notify_error)
                .into(img);

        return view;
    }
}
