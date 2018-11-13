package com.example.ouser.signupandloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SecondActivity extends AppCompatActivity {

        EditText ed1, ed2;
    String userName;
    String userPass;
    String gender2, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ed1=findViewById(R.id.editText4);
        ed2=findViewById(R.id.editText6);
        Intent in= getIntent();
         userName=in.getStringExtra("name");
         userPass=in.getStringExtra("pass");
         gender2=in.getStringExtra("gender");
         email=in.getStringExtra("email");
    }

    public void LogIn(View v){
        String userCheck=ed1.getText().toString();
        String passCheck=ed2.getText().toString();

        if(userName.equals(userCheck) && userPass.equals(passCheck)){
            Intent in= new Intent(SecondActivity.this, ThirdActivity.class);
            in.putExtra("name",userCheck);
            in.putExtra("pass",userPass);
            in.putExtra("gender",gender2);
            in.putExtra("email",email);
            startActivity(in);
        }
    }
}
