package com.kkiwi.kosherkiwi;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Alleras on 11/30/2016.
 */

public class DataReader {

    public static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<Guideline> guidelineList = new ArrayList<>();
    public static ArrayList<Product> filteredProductList = new ArrayList<>();
    public static FilterByCategory filterByCategory = FilterByCategory.PRODUCT;

    public enum FilterByCategory{
        PRODUCT, GROUP, BRAND;
    }

    private String csvSplitBy = ",";


    public DataReader(Context context) throws IOException {
        System.out.println("TEST1");
        AssetManager assetManager = context.getAssets();
        System.out.println("RETRIEVED ASSETS");
        BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open("kosher_list.csv")));
        System.out.println("ACCESSED ASSETS");
        String line ="";
        boolean firstLine = true;

        while((line=br.readLine())!=null){
            System.out.println("TEST");

            if(firstLine){
                firstLine=false;
                continue;
            }
            String[] productDetails;
            productDetails = line.split(csvSplitBy);

            if(productDetails[2].isEmpty()){
                System.out.println("Not adding this.");
                continue;
            }
//            if(productDetails[8].toLowerCase()=="guideline"){
//                Guideline g = new Guideline(productDetails[0], productDetails[1], productDetails[9]);
//                guidelineList.add(g);
//                System.out.println("::Added a guideline::");
//                continue;
//            }
            if(productDetails[3]=="" && productDetails[2]=="") {
                continue;
            }
            Product p = new Product(productDetails);
            productList.add(p);
        }
        System.out.println("THE LAST ENTRY OF FILTERED IS: " +filteredProductList.get(filteredProductList.size()));
        System.out.println("THE LAST ENTRY OF PRODUCT IS: " +productList.get(productList.size()));
        filteredProductList.addAll(productList);
        br.close();
    }

    public static void filterList(String f){
        filteredProductList.clear();
        String filter = f.toLowerCase();
        for(Product p : productList){
            if(p.toString().toLowerCase().contains(filter)){
                filteredProductList.add(p);
            }
        }

        Collections.sort(filteredProductList, new Comparator<Product>(){
            @Override
            public int compare(Product a, Product b){
                return a.compareTo(b);
            }

        });
    }
}
