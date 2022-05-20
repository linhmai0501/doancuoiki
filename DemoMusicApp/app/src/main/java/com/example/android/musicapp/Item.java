package com.example.android.musicapp;

public class Item {

    private String Link;
    private String mFirstLine;

    private String mSecondLine;

    public Item(String firstLine, String secondLine,String link) {
        mFirstLine = firstLine;
        mSecondLine = secondLine;
        Link = link;
    }


    public String getFirstLine() {
        return mFirstLine;
    }


    public String getSecondLine() {
        return mSecondLine;
    }

    public String getLink() {return Link;}
}