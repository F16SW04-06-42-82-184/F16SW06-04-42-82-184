package com.example.ouser.applauncher;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    String input;
    //char inputarr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.editText);
        input=tv1.getText().toString();
    }

    public void Callbtn(View v){
        Intent in= new Intent(Intent.ACTION_CALL);
        in.setData(Uri.parse("tel:"+tv1.getText().toString()));
        startActivity(in);
    }
    public void CameraBtn(View v){
        Intent in= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(in);
    }
    public void ContactBtn(View v){
        Intent in=new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("content://contacts/people/"));
        startActivity(in);
    }
    public void BrowserBtn(View v){
        Intent in= new Intent(Intent.ACTION_VIEW);
        input=tv1.getText().toString();
        in.setData(Uri.parse(input));
        startActivity(in);
    }
    public void CallLogBtn(View v){
        Intent in= new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("content://call_log/calls/1"));
        startActivity(in);
    }
    public void GalleryBtn(View v){
        Intent in= new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("content://media/external/images/media/"));
        startActivity(in);
    }
    public void DialPadBtn(View v){
        Intent in= new Intent(Intent.ACTION_DIAL);
        in.setData(Uri.parse("tel:"+tv1.getText().toString()));
        startActivity(in);
    }
}
