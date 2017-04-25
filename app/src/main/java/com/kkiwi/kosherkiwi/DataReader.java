package com.kkiwi.kosherkiwi;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataReader {

    public static ArrayList<Product> productList = new ArrayList<>();
    public static ArrayList<Guideline> guidelineList = new ArrayList<>();
    public static ArrayList<Product> filteredProductList = new ArrayList<>();
    public static FilterByCategory filterByCategory = FilterByCategory.PRODUCT;

    public enum FilterByCategory{
        PRODUCT, GROUP, BRAND
    }

    private String csvSplitBy = ",";

    public DataReader(Context context) throws IOException {
        AssetManager assetManager = context.getAssets();
        BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open("kosher_list.csv")));
        String line = "";
        boolean firstLine = true;

        while((line=br.readLine())!=null){

            if(firstLine){
                firstLine=false;
                continue;
            }
            String[] productDetails;
            productDetails = line.split(csvSplitBy);

            if(productDetails[2].isEmpty()){
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
