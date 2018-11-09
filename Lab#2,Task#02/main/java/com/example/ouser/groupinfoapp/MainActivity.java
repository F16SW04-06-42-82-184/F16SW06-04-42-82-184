package com.example.ouser.groupinfoapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String NameArr[]= {"Zainab Khan", "Hiba Haque", "Maha Agro", "Fiza Azam", "Hira Abid Khan"};
    String RollArr[]={"F16SW06", "F16SW04", "F16SW82", "F16SW42", "F16SW184"};
    String EmailArr[]={"zainabyounus63@mail.com","hibahaq05@gmail.com","mahaagro48@gmail.com","fiza_et@outlook.com","hiraabidkhan17@gmail.com"};
    String DobArr[]={"24-Feb-1998", "20-Feb-1999","07-Apr-1998", "06-June-1999","17-June-1997"};
    int ImageArr[]={R.drawable.zainab_image, R.drawable.hiba_image, R.drawable.maha_image, R.drawable.fiza_image, R.drawable.hira_image};
    Drawable dr1;
    ImageView im1;

    TextView t1, t2, t3, t4;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        im1=(ImageView) findViewById(R.id.imageView);

        t1.setText(NameArr[0]);
        t2.setText(RollArr[0]);
        t3.setText(EmailArr[0]);
        t4.setText(DobArr[0]);
        im1.setImageDrawable(getResources().getDrawable(ImageArr[0]));
    }

    public void next(View v){
        count++;
        if(count<5) {
            t1.setText(NameArr[count]);
            t2.setText(RollArr[count]);
            t3.setText(EmailArr[count]);
            t4.setText(DobArr[count]);
            im1.setImageDrawable(getResources().getDrawable(ImageArr[count]));
        }
        else if(count>=5){
            t1.setText(NameArr[4]);
            t2.setText(RollArr[4]);
            t3.setText(EmailArr[4]);
            t4.setText(DobArr[4]);
            im1.setImageDrawable(getResources().getDrawable(ImageArr[4]));
            count--;
        }
    }

    public void prev(View v){
        count--;
        if(count>=0 && count<5) {
            t1.setText(NameArr[count]);
            t2.setText(RollArr[count]);
            t3.setText(EmailArr[count]);
            t4.setText(DobArr[count]);
            im1.setImageDrawable(getResources().getDrawable(ImageArr[count]));
        }
        if(count<0){
            t1.setText(NameArr[0]);
            t2.setText(RollArr[0]);
            t3.setText(EmailArr[0]);
            t4.setText(DobArr[0]);
            im1.setImageDrawable(getResources().getDrawable(ImageArr[0]));
            count++;
        }
    }
}
