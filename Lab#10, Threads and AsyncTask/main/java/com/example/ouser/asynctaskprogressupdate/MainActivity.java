package com.example.ouser.asynctaskprogressupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progress;
    Button button;
    AsyncProgress prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
    }

    public void RunBtn(View v){
        progress.setProgress(0);
        prog= (AsyncProgress) new AsyncProgress(getApplicationContext(), progress).execute(10);
    }
}
