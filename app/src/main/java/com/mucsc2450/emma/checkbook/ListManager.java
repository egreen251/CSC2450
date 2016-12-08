package com.mucsc2450.emma.checkbook;

import java.util.ArrayList;

public class ListManager {
    public ArrayList<ListManager> list;

    public String date, description, amount, type, balance;

    public ListManager() {
        list = new ArrayList<ListManager>();
    }

    public static ArrayList<ListManager> getList(){

        return ListManager.getInstance().list;
    }

    public static void addListItems(String date, String desc, String type, String amount, String balance){

        ListManager listObj = new ListManager();

        listObj.date = date;
        listObj.description = desc;
        listObj.type = type;
        listObj.amount = amount;
        listObj.balance = balance;

        ListManager.getInstance().list.add(listObj);
    }

    private static ListManager instance;

    public static ListManager getInstance() {
        if (instance == null) instance = new ListManager();
        return instance;
    }
}