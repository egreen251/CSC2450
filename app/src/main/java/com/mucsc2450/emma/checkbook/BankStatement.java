package com.mucsc2450.emma.checkbook;



        import android.content.Intent;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class BankStatement extends AppCompatActivity {

    private Button mSendButton, mGoBackButton;
    private EditText mEmailInput;
    private String mSubject;
    private RadioGroup mStatementType;
    private RadioButton mStatementChecking, mStatementSavings, mStatementTypeButton;
    private String mMessage = "";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_statement);


        mSendButton = (Button) findViewById(R.id.sendbutton);
        mGoBackButton = (Button) findViewById(R.id.gobackbutton);
        mEmailInput = (EditText) findViewById(R.id.emailaddress);
        mStatementType = (RadioGroup) findViewById(R.id.BankStatementAccount);
        mStatementChecking = (RadioButton) findViewById(R.id.BankStatementChecking);
        mStatementSavings = (RadioButton) findViewById(R.id.BankStatementSavings);
        mSubject = "Bank Statement";




    mSendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

            int mStatementType_Id = mStatementType.getCheckedRadioButtonId();
            mStatementTypeButton = (RadioButton) findViewById(mStatementType_Id);

            if (mStatementTypeButton == mStatementChecking) {

                final ArrayList<ListManager> itemList = ListManager.getList();

                String[] listItems = new String[ListManager.getInstance().list.size()];

                for (int i = 0; i < itemList.size(); i++) {
                    ListManager item = itemList.get(i);
                    mMessage += item.date + "   " + item.description + "   " + item.type + "   $" + item.amount + "   $" + item.balance+"\n ";



                }
            }
                if (mStatementTypeButton == mStatementSavings) {

                    final ArrayList<SavingsListManager> savingsitemList = SavingsListManager.getList();

                    String[] savingslistItems = new String[SavingsListManager.getInstance().list.size()];

                    for (int i = 0; i < savingsitemList.size(); i++) {
                        SavingsListManager item = savingsitemList.get(i);
                        mMessage += item.date + "   " + item.description + "   " + item.type + "   " + item.amount + "   " + item.balance+"\n";




                    }
                }


                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{mEmailInput.getText().toString()});
                    i.putExtra(Intent.EXTRA_SUBJECT, mSubject);
                    i.putExtra(Intent.EXTRA_TEXT, mMessage);

                    if (i.resolveActivity(getPackageManager()) != null) {
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(BankStatement.this,
                                "There are no email clients installed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            mGoBackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(BankStatement.this, HomePage.class);
                    startActivity(i);
                }


            });

        }
    }

