package com.kkiwi.kosherkiwi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    private Product product = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        product = DataReader.filteredProductList.get(getIntent().getIntExtra("productIndex",0));
        System.out.println(product);

        loadProductDetails();
    }


    public void loadProductDetails(){
        TextView tvProduct = (TextView)findViewById(R.id.productDescription);
        TextView tvBrand = (TextView)findViewById(R.id.productBrand);
        TextView tvGroup = (TextView)findViewById(R.id.productGroup);
        TextView tvSubgroup = (TextView)findViewById(R.id.productSubgroup);
        ImageView ivIcon = (ImageView)findViewById(R.id.productImage);


        tvProduct.setText("\r\n"+product.toString());
        tvBrand.setText(product.getBrand());
        tvGroup.setText(product.getGroup());
        tvSubgroup.setText(product.getSubGroup());
        ivIcon.setImageResource(product.getIconType());
    }

    public void backToMain(View v){
        this.finish();
    }
}
