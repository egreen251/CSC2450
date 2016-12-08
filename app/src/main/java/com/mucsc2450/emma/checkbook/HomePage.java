package com.mucsc2450.emma.checkbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button mCheckingButton, mSavingsButton, mBankStatementButton;

        mCheckingButton = (Button) findViewById(R.id.CheckingButton);
        mSavingsButton = (Button) findViewById(R.id.SavingsButton);
        mBankStatementButton = (Button) findViewById(R.id.BankStatement);

        mCheckingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomePage.this, CheckingAccount.class);
                startActivity(i);
            }
        });

        mSavingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomePage.this, SavingsAccount.class);
                startActivity(i);
            }


        });
        mBankStatementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomePage.this, BankStatement.class);
                startActivity(i);
            }


        });


    }




}

