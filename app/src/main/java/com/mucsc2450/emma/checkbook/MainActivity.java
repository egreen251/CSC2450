package com.mucsc2450.emma.checkbook;

import android.content.Intent;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText mUsername, mPassword;
    private Button mLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUser = mUsername.getText().toString();
                String mPass = mPassword.getText().toString();

                if(mUser.equals("egreen")&& mPass.equals("pass123")){
                    Intent i = new Intent (MainActivity.this, HomePage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }

            };
        });



    }
}
