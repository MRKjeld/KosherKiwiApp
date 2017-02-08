package com.kkiwi.kosherkiwi;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Alleras on 11/30/2016.
 */

//removed guideline.

public class Product implements Comparable<Product> {

    private String group = "";
    private String subGroup = "";
    private String brand = "";
    private String productName = "";
    private int iconType = 0;
    private String logo = "";
    private String comment = "";
    private String updated = "";            //date last updated, should be included later, for now everything is null anyway.
    private String barcode = "";            //not really a feature atm.
    //private boolean isGuideline = false;    //set to true if a guideline and NOT a product. Not the best way to deal with it, but will address again later.

    public Product(String[] productDetails){
        try {
            group = productDetails[0];
            subGroup = productDetails[1];
            brand = productDetails[2];
            productName = productDetails[3];
            setIconType(productDetails[4]);
            logo = productDetails[5];
            comment = productDetails[6];
            updated = productDetails[7];
            barcode = productDetails[8];
//            if (productDetails[9] == "Guideline") {
//                isGuideline = true;
//            }
        }
        catch(Exception e){
            System.out.println("error in setting details. missing fields/commas in CSV?");
        }
    }

    public String getSubGroup(){
        return subGroup;
    }

    public void setIconType(String s){
        switch(s.charAt(0)){
            case 'p':
            case 'P':
                iconType=R.drawable.parve;
                break;
            case 'D':
            case 'd':
                iconType=R.drawable.milk;
                break;
            case 'F':
            case 'f':
            case 'm':
            case 'M':
                iconType=R.drawable.meat;
                break;
            default:
                iconType=R.drawable.parve;
                break;
        }
    }

    public String getProductName(){
        return this.productName;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getGroup(){
        return this.group;
    }
    public int getIconType(){
        return iconType;
    }


    public String getFilterDetail(){
        String s = "";
        switch(DataReader.filterByCategory){
            case PRODUCT:
                return productName;
            case GROUP:
                return group;
            case BRAND:
                return brand;
        }
        return s; //never touched, I imagine.
    }

    public int compareTo(Product p){
        String compareProduct = p.getFilterDetail();
        return this.getFilterDetail().compareTo(compareProduct);
    }

    @Override
    public String toString(){
        String s = getProductName() + " " + getBrand() + " " + getGroup() + " " +getSubGroup();
        return s;
    }
}
