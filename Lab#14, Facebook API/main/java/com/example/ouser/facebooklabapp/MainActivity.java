package com.example.ouser.facebooklabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;
    private CallbackManager callbackManager;
    Profile mProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        loginButton = findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        //Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            ProfileTracker profileTracker;
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                mProfile = Profile.getCurrentProfile();
                Toast.makeText(MainActivity.this,"Success not null",Toast.LENGTH_LONG).show();

                if(mProfile == null) {
                    profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                            Log.v("facebook-profile", currentProfile.getFirstName());
                            profileTracker.stopTracking();
                            mProfile = Profile.getCurrentProfile();

                            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                            //getting user data
                            String firstName = mProfile.getFirstName();
                            String lastName = mProfile.getLastName();
                            String userId = mProfile.getId();
                            String profileImageUrl = mProfile.getProfilePictureUri(200,200).toString();

                            Intent facebookIntent = new Intent(MainActivity.this, UserProfile.class);
                            facebookIntent.putExtra("USER_ID", userId);
                            facebookIntent.putExtra("PROFILE_FIRST_NAME", firstName);
                            facebookIntent.putExtra("PROFILE_LAST_NAME", lastName);
                            facebookIntent.putExtra("PROFILE_IMAGE_URL", profileImageUrl);
                            startActivity(facebookIntent);
                        }
                    };
                    //no need to call startTracking() on mProfileTracker
                    //because it is called by its constructor, internally.
                }
                else{
                    //Profile profile = Profile.getCurrentProfile();
                    String firstName = mProfile.getFirstName();
                    String lastName = mProfile.getLastName();
                    String userId = mProfile.getId();
                    String profileImageUrl = mProfile.getProfilePictureUri(200,200).toString();

                    Intent facebookIntent = new Intent(MainActivity.this, UserProfile.class);
                    facebookIntent.putExtra("USER_ID", userId);
                    facebookIntent.putExtra("PROFILE_FIRST_NAME", firstName);
                    facebookIntent.putExtra("PROFILE_LAST_NAME", lastName);
                    facebookIntent.putExtra("PROFILE_IMAGE_URL", profileImageUrl);
                    startActivity(facebookIntent);

                    //Log.v("facebook-profile", profile.getLastName());
                }
            }


            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Failed to Log-in", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

    }
}
