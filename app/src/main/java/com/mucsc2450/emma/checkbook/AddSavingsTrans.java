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


public class AddSavingsTrans extends AppCompatActivity {

    EditText mSavingsTransDesc, mSavingsTransAmount, mSavingsTransDate;
    String mSTransType, SendBalance, mSavingsDate;
    RadioGroup mSavingsTransType;
    RadioButton mTransTypeButton, mSavingsCredit, mSavingsDebit;
    Button mSavingsTransSubmit;
    int mSavingsTransTypeSelected;
    double mSavingsAmount, balance, newBalance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings_trans);

        mSavingsTransDate = (EditText) findViewById(R.id.SavingsTransDate);
        mSavingsTransDesc = (EditText) findViewById(R.id.SavingsTransDesc);
        mSavingsTransAmount = (EditText) findViewById(R.id.SavingsTransAmount);
        mSavingsTransType = (RadioGroup) findViewById(R.id.SavingsTransType);
        mSavingsTransSubmit = (Button) findViewById(R.id.SavingsTransSubmit);
        mSavingsCredit = (RadioButton) findViewById(R.id.SavingsCredit);
        mSavingsDebit = (RadioButton) findViewById(R.id.SavingsDebit);



        mSavingsTransSubmit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //mCheckingDesc = mCheckingTransDesc.getText().toString();
                mSavingsAmount = Double.parseDouble(mSavingsTransAmount.getText().toString());
                mSavingsDate = mSavingsTransDate.getText().toString();
                int mSavingsTransTypeSelected_Id = mSavingsTransType.getCheckedRadioButtonId();
                mTransTypeButton = (RadioButton) findViewById(mSavingsTransTypeSelected_Id);
                if (mTransTypeButton == mSavingsCredit) {
                    mSavingsTransTypeSelected = 0;
                    mSTransType = "-";
                }
                if (mTransTypeButton == mSavingsDebit) {
                    mSavingsTransTypeSelected = 1;
                    mSTransType = "+";
                }

                final ArrayList<SavingsListManager> savingsitemList = SavingsListManager.getList();
                String[] savingslistItems = new String[ListManager.getInstance().list.size()];

                for (int i = 0; i < savingsitemList.size(); i++) {
                    SavingsListManager item = savingsitemList.get(i);
                    balance = Double.parseDouble(item.balance);
                }


                if (mSavingsTransTypeSelected == 0) {
                    newBalance = balance - mSavingsAmount;
                }
                if (mSavingsTransTypeSelected == 1) {
                    newBalance = balance + mSavingsAmount;
                }


                SendBalance = Double.toString(newBalance);


                Intent i2 = new Intent(AddSavingsTrans.this, SavingsAccount.class);
                SavingsListManager.addListItems(mSavingsDate, mSavingsTransDesc.getText().toString(), mSTransType,
                        mSavingsTransAmount.getText().toString(), SendBalance);
                startActivity(i2);
            }

        });

    };
}
