package com.candybreaker.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MsgActivity extends MainActivity{
    public EditText tex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        TextView tex = (TextView)findViewById(R.id.em);
        Button b2 = (Button) findViewById(R.id.b2);
        tex2 = (EditText)findViewById(R.id.tm);
    }

    public void resultBtn(View v){
        Intent retIntent = new Intent();
        retIntent.putExtra("tm", tex2.getText().toString());
        setResult(RESULT_OK, retIntent);
        finish();
    }

}
