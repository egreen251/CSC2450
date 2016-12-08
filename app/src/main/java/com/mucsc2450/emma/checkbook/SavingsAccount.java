package com.mucsc2450.emma.checkbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SavingsAccount extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_account);

        mListView = (ListView) findViewById(R.id.listview);

        final ArrayList<SavingsListManager> savingsitemList = SavingsListManager.getList();

        String[] savingslistItems = new String[SavingsListManager.getInstance().list.size()];

        for(int i = 0; i < savingsitemList.size(); i++){
            SavingsListManager item = savingsitemList.get(i);
            savingslistItems[i] = item.date+"   "+item.description +"   "+ item.type+"   $" + item.amount +"    $" + item.balance;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.listview, savingslistItems);
        mListView.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_savingsTrans) {
            Intent intent = new Intent(this, AddSavingsTrans.class);
            startActivity(intent);
        }
        if (id == R.id.home) {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }



}




