package com.example.ouser.signupandloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    String user, email, gender3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        t1=findViewById(R.id.textView5);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView9);
        Intent in= getIntent();
        user=in.getStringExtra("name");
        email=in.getStringExtra("email");
        gender3=in.getStringExtra("gender");

        t1.setText("Name: "+user);
        t2.setText("Email: "+email);
        t3.setText("Gender: "+gender3);
    }
}
