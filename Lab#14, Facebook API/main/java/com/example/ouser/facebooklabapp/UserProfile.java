package com.example.ouser.facebooklabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;

public class UserProfile extends AppCompatActivity {

    ImageView profileImage;
    TextView id, name;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileImage = findViewById(R.id.imageView);
        id = findViewById(R.id.textView);
        name = findViewById(R.id.textView2);
        fb = findViewById(R.id.floatingActionButton);

        FacebookSdk.sdkInitialize(getApplicationContext());
        Intent intent = getIntent();

        String UserID = intent.getStringExtra("USER_ID");
        String FirstName = intent.getStringExtra("PROFILE_FIRST_NAME");
        String LastName = intent.getStringExtra("PROFILE_LAST_NAME");
        String ProfileURL = intent.getStringExtra("PROFILE_IMAGE_URL");

        id.setText(UserID);
        name.setText(FirstName+" "+LastName);
        Picasso.with(UserProfile.this).load(ProfileURL).into(profileImage);

        Toast.makeText(this, "PROFILE IMAGE URL"+ ProfileURL, Toast.LENGTH_LONG).show();

        fb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ShareDialog shareDialog = new ShareDialog(UserProfile.this);
                ShareLinkContent content = new ShareLinkContent.Builder().build();
                shareDialog.show(content);
            }
        });
    }
}
