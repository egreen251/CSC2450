package com.mucsc2450.emma.checkbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class AddCheckingTrans extends AppCompatActivity {

    EditText mCheckingTransDesc, mCheckingTransAmount, mCheckingTransDate;
    String mCkTransType, SendBalance, mCheckingDate;
    RadioGroup mCheckingTransType;
    RadioButton mTransTypeButton, mCheckingCredit, mCheckingDebit;
    Button mCheckingTransSubmit;
    int mCheckingTransTypeSelected;
    double mCheckingAmount, balance, newBalance;



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_checking_trans2);

       mCheckingTransDate = (EditText) findViewById(R.id.CheckingTransDate);
       mCheckingTransDesc = (EditText) findViewById(R.id.CheckingTransDesc);
        mCheckingTransAmount = (EditText) findViewById(R.id.CheckingTransAmount);
        mCheckingTransType = (RadioGroup) findViewById(R.id.CheckingTransType);
        mCheckingTransSubmit = (Button) findViewById(R.id.CheckingTransSubmit);
        mCheckingCredit = (RadioButton) findViewById(R.id.CheckingCredit);
        mCheckingDebit = (RadioButton) findViewById(R.id.CheckingDebit);



mCheckingTransSubmit.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        //mCheckingDesc = mCheckingTransDesc.getText().toString();
        mCheckingAmount = Double.parseDouble(mCheckingTransAmount.getText().toString());
        mCheckingDate = mCheckingTransDate.getText().toString();
        int mCheckingTransTypeSelected_Id = mCheckingTransType.getCheckedRadioButtonId();
        mTransTypeButton = (RadioButton) findViewById(mCheckingTransTypeSelected_Id);
        if (mTransTypeButton == mCheckingCredit) {
            mCheckingTransTypeSelected = 0;
            mCkTransType = "-";
        }
        if (mTransTypeButton == mCheckingDebit) {
            mCheckingTransTypeSelected = 1;
            mCkTransType = "+";
        }

        final ArrayList<ListManager> itemList = ListManager.getList();
        String[] listItems = new String[ListManager.getInstance().list.size()];

        for (int i = 0; i < itemList.size(); i++) {
            ListManager item = itemList.get(i);
            balance = Double.parseDouble(item.balance);
        }


        if (mCheckingTransTypeSelected == 0) {
            newBalance = balance - mCheckingAmount;
        }
        if (mCheckingTransTypeSelected == 1) {
            newBalance = balance + mCheckingAmount;
        }


        SendBalance = Double.toString(newBalance);


        Intent i2 = new Intent(AddCheckingTrans.this, CheckingAccount.class);
        ListManager.addListItems(mCheckingDate, mCheckingTransDesc.getText().toString(), mCkTransType,
                mCheckingTransAmount.getText().toString(), SendBalance);
        startActivity(i2);
    }

});

   };
}




