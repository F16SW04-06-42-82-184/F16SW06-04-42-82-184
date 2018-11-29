package com.example.ouser.recyclerviewtask;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{

    List<String> list;
    Context c;
    public RecyclerAdapter(Context c, List<String> list){

        this.list=list;
        this.c=c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_layout, parent, false);
        MyViewHolder mv= new MyViewHolder(v);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int position) {

        viewHolder.iv.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tv.setText(list.get(position));
        viewHolder.lv.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               Toast.makeText(c,"element clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        LinearLayout lv;
        ImageView iv;
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.TextView);
            iv=itemView.findViewById(R.id.ImageView);
            lv=itemView.findViewById(R.id.linear_layout);
        }
    }
}
