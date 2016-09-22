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

    private TextView textHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Log.v(TAG, "In Home onCreate");
        textHome = (TextView) findViewById(R.id.textHome);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            UserProfile user = bundle.getParcelable("user");
            textHome.setText(user.getFname() + " " + user.getLname() + "\n\n" + user.getContact() + "\n\n" + user.getEmail() + "\n\n" + user.getGender() + "\n\n" + user.getAddress() + "\n\n" + user.getSecurityQuestion() + "\n\n" + user.getSecurityAnswer());
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
