package com.dangminhdang.k22411canewsample.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

Activity context;
int resource;
public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View item = inflater.inflate(resource, null);
        TextView txtProductId=item.findViewById(R.id.txtProductId);
        TextView txtProductName=item.findViewById(R.id.txtProductName);
        TextView txtProductQuantity=item.findViewById(R.id.txtProductQuantity);
        TextView txtProductPrice=item.findViewById(R.id.txtProductPrice);
        ImageView imgProduct=item.findViewById(R.id.imgProduct);
        ImageView imgCart=item.findViewById(R.id.imgCart);
        Product p = getItem(position);

// sau đó rải dữ liệu từ Product lên giao diện cho người dùng:
        txtProductId.setText(p.getId() + "");
        txtProductName.setText(p.getName());
        txtProductQuantity.setText(p.getQuantity() + "");
        txtProductPrice.setText(p.getPrice() + " (VND)");
        imgProduct.setImageResource(p.getImage_id());
        return item;
    }
}
