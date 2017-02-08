package com.kkiwi.kosherkiwi;


public class Guideline {

    //the aim is to eventually display guidelines in a seperate swipe activity

    private String group = ""; //0
    private String subgroup = ""; //1
    private String comment = ""; //6

    public Guideline(String group, String subgroup, String comment){
        this.group = group;
        this.subgroup = subgroup;
        this.comment = comment;
    }
}
