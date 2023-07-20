package com.BlogDemo.BlogDemo2.Model;

import java.util.ArrayList;

public class User {
    private ArrayList<String> yourList;

    public User (){
        yourList = new ArrayList<>();
    }

    public ArrayList<String> getYourList() {
        return yourList;
    }
    public void setYourList(ArrayList<String> yourList) {
        this.yourList = yourList;
    }


}
