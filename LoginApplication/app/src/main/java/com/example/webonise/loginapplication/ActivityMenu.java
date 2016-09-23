package com.example.webonise.loginapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {

    public final static String CUSTOM_INTENT = "com.tutorialspoint.CUSTOM_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            InventoryClass inventory = bundle.getParcelable("inventory");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                onLogoutClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onLogoutClicked() {
        broadcastIntent();
        SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("userlogin", false);
        edit.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void broadcastIntent() {
        Intent intentBroadcast = new Intent();
        intentBroadcast.setAction("com.example.webonise.broadcastsample.ACTION_LOGOUT");
//        intentBroadcast.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intentBroadcast);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InventoryFormActivity.class);
        startActivity(intent);
    }
}
