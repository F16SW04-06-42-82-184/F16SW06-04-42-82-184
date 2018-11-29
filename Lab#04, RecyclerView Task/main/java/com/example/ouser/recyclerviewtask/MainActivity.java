package com.example.ouser.recyclerviewtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    List<String> list;
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.RecyclerView);
        //declaration of linear layout manager
        lm=new LinearLayoutManager(this);
        //setting the layout manager to RecyclerView
        rv.setLayoutManager(lm);

        //creating list
        ArrayList<String> ListItem= new ArrayList<String>();
        for(int i=0; i<50; i++){
            ListItem.add(i+" element");
        }
        //initializing list
        list=ListItem;
        rv.setHasFixedSize(true);
        adapter= new RecyclerAdapter(this, list);
        rv.setAdapter(adapter);
    }
}
