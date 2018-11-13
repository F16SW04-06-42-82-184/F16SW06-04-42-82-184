package com.example.ouser.signupandloginapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText username, email, password;
    RadioButton rd1, rd2;
    Button btn;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        rd1=findViewById(R.id.radioButton);
        rd2=findViewById(R.id.radioButton2);
        if(rd1.isChecked()){
            gender="Male";
        }
        if(rd2.isChecked()){
            gender="Female";
        }
    }

    public void SignUpClick(View v){
        Intent in= new Intent(MainActivity.this, SecondActivity.class);
        in.putExtra("name",username.getText().toString());
        in.putExtra("pass",password.getText().toString());
        in.putExtra("gender",gender);
        in.putExtra("email",email.getText().toString());
        startActivity(in);
    }
}
