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

public class CheckingAccount extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_account);

        mListView = (ListView) findViewById(R.id.listview);

        final ArrayList<ListManager> itemList = ListManager.getList();

        String[] listItems = new String[ListManager.getInstance().list.size()];

        for(int i = 0; i < itemList.size(); i++){
            ListManager item = itemList.get(i);
            listItems[i] = item.date+"   "+item.description +"   "+ item.type+"   $" + item.amount +"    $" + item.balance;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.listview, listItems);
        mListView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_checkingTrans) {
            Intent intent = new Intent(this, AddCheckingTrans.class);
            startActivity(intent);
        }
        if (id == R.id.home) {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }


}
