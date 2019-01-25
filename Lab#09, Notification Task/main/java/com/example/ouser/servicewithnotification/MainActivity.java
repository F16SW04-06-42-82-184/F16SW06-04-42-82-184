package com.example.ouser.servicewithnotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
