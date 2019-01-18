package com.candybreaker.user.textbroadcast;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //MyBroadcast myBroadcast = new MyBroadcast();
    public static final int REQUEST_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestPermission();
    }
    private boolean RequestPermission(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            int ReadSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
            int ReceiveSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
            List<String> permissionRequired = new ArrayList<>();
            if(ReadSMS!=PackageManager.PERMISSION_GRANTED) { permissionRequired.add(Manifest.permission.READ_SMS); }
            if(ReceiveSMS!=PackageManager.PERMISSION_GRANTED){ permissionRequired.add(Manifest.permission.RECEIVE_SMS);}
            if(!permissionRequired.isEmpty()){
                ActivityCompat.requestPermissions( this,
                        permissionRequired.toArray(new String[permissionRequired.size()]), REQUEST_PERMISSION);
                return false;
            }
        return true;

        } else{
            return true;
        }
    }
}
