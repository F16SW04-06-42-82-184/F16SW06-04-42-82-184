package com.candybreaker.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int Req_cd=1;
    public TextView text;
    //public EditText ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.tv);
      //  ts = (EditText)findViewById(R.id.test);
        Button button = (Button) findViewById(R.id.b);
    }

        public void btClick(View v){
        Req_cd=1;
        Intent in = new Intent(MainActivity.this, MsgActivity.class);
        startActivityForResult(in, Req_cd);
        }

        public void onActivityResult(int Reqcode, int Rescode, Intent data){
        super.onActivityResult(Reqcode, Rescode, data );
        if(Reqcode==Req_cd){
            if(Rescode==RESULT_OK){
                String st = data.getStringExtra("tm");
                text.setText(st);
                //ts.setText(st);
            }
        }


        }

}
