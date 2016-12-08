package com.mucsc2450.emma.checkbook;

import java.util.ArrayList;

public class SavingsListManager {
    public ArrayList<SavingsListManager> list;

    public String date, description, amount, type, balance;

    public SavingsListManager() {
        list = new ArrayList<SavingsListManager>();
    }

    public static ArrayList<SavingsListManager> getList(){

        return SavingsListManager.getInstance().list;
    }

    public static void addListItems(String date, String desc, String type, String amount, String balance){

        SavingsListManager listObj = new SavingsListManager();

        listObj.date = date;
        listObj.description = desc;
        listObj.type = type;
        listObj.amount = amount;
        listObj.balance = balance;

        SavingsListManager.getInstance().list.add(listObj);
    }

    private static SavingsListManager savingsinstance;

    public static SavingsListManager getInstance() {
        if (savingsinstance == null) savingsinstance = new SavingsListManager();
        return savingsinstance;
    }
}