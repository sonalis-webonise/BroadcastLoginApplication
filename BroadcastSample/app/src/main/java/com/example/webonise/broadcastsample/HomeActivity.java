package com.example.webonise.broadcastsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by webonise on 16/9/16.
 */
public class HomeActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    public static final String user="user";

    private TextView textHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Log.v(TAG, "In Home onCreate");
        textHome = (TextView) findViewById(R.id.textHome);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            UserProfile userProfile = bundle.getParcelable(user);
            textHome.setText(userProfile.getFname() + " " + userProfile.getLname() + "\n\n" + userProfile.getContact() + "\n\n" + userProfile.getEmail() + "\n\n" + userProfile.getGender() + "\n\n" + userProfile.getAddress() + "\n\n" + userProfile.getSecurityQuestion() + "\n\n" + userProfile.getSecurityAnswer());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "In Home onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "In Home onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "In Home onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "In Home onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "In Home onDestroy");
    }
}
