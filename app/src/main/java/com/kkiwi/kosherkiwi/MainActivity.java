package com.kkiwi.kosherkiwi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import static com.kkiwi.kosherkiwi.R.layout.activity_main;

/**
 * Created by Alleras on 11/15/2016.
 */



public class MainActivity extends Activity {

    Context context = null;
    ListView list;
    DataReader dr = null;

    public void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(activity_main);
        context=this.getApplicationContext();
        if(DataReader.productList==null) {
            try {
                dr = new DataReader(getApplicationContext());
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }
        }
        useSearchFilter();
        generateList();
    }

    public void generateList(){

        ProductListAdapter pla = new ProductListAdapter(this, DataReader.filteredProductList);

        list = (ListView)findViewById(R.id.list);
        list.setAdapter(pla);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //to be done for when an item is clicked.
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("productIndex", i);
                startActivity(intent);
            }
        });
    }

    public void searchButtonOnClick(View v){
        useSearchFilter();
        generateList();
    }

    public void useSearchFilter(){
        TextView tvSearch = (TextView)findViewById(R.id.txtSearchText);
        String search = tvSearch.getText().toString();
        dr.filterList(search);
    }

    public void productOnClick(View v){
        DataReader.filterByCategory= DataReader.FilterByCategory.PRODUCT;
        useSearchFilter();
        generateList();
    }
    public void brandOnClick(View v){
        DataReader.filterByCategory= DataReader.FilterByCategory.BRAND;
        useSearchFilter();
        generateList();
    }
    public void groupOnClick(View v){
        DataReader.filterByCategory= DataReader.FilterByCategory.GROUP;
        useSearchFilter();
        generateList();
    }
}
