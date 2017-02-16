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
            setIconType(productDetails[0]);
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
        switch(s){
            case "Alcohol":
                iconType=R.drawable.alcohol;
                break;
            case "Baby Foods":
                iconType=R.drawable.baby_foods;
                break;
            case "Baby Formula":
                iconType=R.drawable.baby_formula;
                break;
            case "Baking Ingredients":
                iconType=R.drawable.baking_ingredients;
                break;
            case "Cereals":
                iconType=R.drawable.cereals;
                break;
            case "Chips, Snacks, Nuts and Dips":
                iconType=R.drawable.snacks;
                break;
            case "Confectionary":
                iconType=R.drawable.confectionary;
                break;
            case "Custard Powder":
                iconType=R.drawable.custard;
                break;
            case "Dairy Products":
                iconType=R.drawable.dairy;
                break;
            case "Fish":
                iconType=R.drawable.fish;
                break;
            case "Fruit":
                iconType=R.drawable.fruit;
                break;
            case "Gluten Free":
                iconType=R.drawable.gluten_free;
                break;
            case "Gravy Mixes":
                iconType=R.drawable.gravy;
                break;
            case "Health bars, Supplements & Vitamins":
                iconType=R.drawable.health;
                break;
            case "Jams, Conserves & Marmalades":
                iconType=R.drawable.jam;
                break;
            case "Juices and Cordials":
                iconType=R.drawable.juice;
                break;
            case "Mayonnaise & Dressings":
                iconType=R.drawable.sauce;
                break;
            case "Meat Substitutes":
                iconType=R.drawable.meat;
                break;
            case "Medical":
                iconType=R.drawable.medicine;
                break;
            case "Milk Products":
                iconType=R.drawable.dairy;
                break;
            case "Mustards":
                iconType=R.drawable.mustard;
                break;
            case "Oil & Oil Sprays":
                iconType=R.drawable.oil;
                break;
            case "Pasta, Rice and Pulses":
                iconType=R.drawable.pasta;
                break;
            case "Pastry":
                iconType=R.drawable.pastry;
                break;
            case "Pickles & Relishes":
                iconType=R.drawable.pickles;
                break;
            case "Puddings - Instant":
                iconType=R.drawable.pudding;
                break;
            case "Salt & Salt Substitutes":
                iconType=R.drawable.salt;
                break;
            case "Sauces & Marinades":
                iconType=R.drawable.marinade;
                break;
            case "Soups":
                iconType=R.drawable.soup;
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
