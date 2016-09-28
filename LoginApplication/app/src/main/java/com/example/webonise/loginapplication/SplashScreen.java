package com.example.webonise.loginapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    public final static String user="user";
    public final static String userlogin="userlogin";
    SharedPreferences sharedPreferences;

    public boolean login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                sharedPreferences=getSharedPreferences(user,0);
                Boolean islogin=sharedPreferences.getBoolean(userlogin,false);
                if (islogin){
                    Intent intentHome = new Intent(SplashScreen.this,ActivityMenu.class);
                    startActivity(intentHome);
                    finish();
                    return;
                }
                else {
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);

                }
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
