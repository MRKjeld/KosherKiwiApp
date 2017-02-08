package com.kkiwi.kosherkiwi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Micha on 12/08/2016.
 */

public class ProductListAdapter extends ArrayAdapter<Product> {
    private Activity context;
    private ArrayList<Product> productList;
    private final int MAX_LETTER_COUNT = 30;

    public ProductListAdapter(Activity context, ArrayList<Product> productList){
        super(context, R.layout.list_product, productList); //the product list is already filtered via main activity.
        this.context = context;
        this.productList=productList;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater li = context.getLayoutInflater();
        View row = li.inflate(R.layout.list_product,null,true);

        TextView tvProduct = (TextView)row.findViewById(R.id.txtProduct);
        TextView tvBrand = (TextView)row.findViewById(R.id.txtBrand);
        TextView tvGroup = (TextView)row.findViewById(R.id.txtGroup);
        ImageView ivIcon = (ImageView)row.findViewById(R.id.icon);

        String productName = productList.get(position).getProductName();
        if(productName.length()>MAX_LETTER_COUNT){
            productName = productName.substring(0,MAX_LETTER_COUNT).concat("...");
        }

        tvProduct.setText(productName);
        tvBrand.setText(productList.get(position).getBrand());
        tvGroup.setText(productList.get(position).getGroup());
        if(productList.get(position).getIconType()!=0) {
            ivIcon.setImageResource(productList.get(position).getIconType());
        }

        return row;
    }
}
