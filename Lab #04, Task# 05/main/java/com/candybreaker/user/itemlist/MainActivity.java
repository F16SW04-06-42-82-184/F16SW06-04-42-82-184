package com.candybreaker.user.itemlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        initimageBitmaps();
        }

    private void initimageBitmaps(){
        Log.d(TAG, "initimageBitmaps: preparing Bitmaps");

        mImage.add("R.drawable.ic_launcher_background");
        mNames.add("0 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ei-sc-github.svg");
        mNames.add("1 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ei-sc-github.svg");
        mNames.add("2 element");

        mImage.add("R.mipmap.ic_launcher.png");
        mNames.add("3 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("4 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("5 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("6 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("7 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("8 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("9 element");

        mImage.add("https://upload.wikimedia.org/wikipedia/commons/f/f1/Android_sample.svg");
        mNames.add("10 element");

        initRecycleView();
    }

    private void initRecycleView(){
        Log.d(TAG, "initRecycleView: init recylcleview");
        RecyclerView recyclerView = findViewById(R.id.recylerv_View);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImage, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
