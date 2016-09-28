
package com.example.webonise.broadcastsample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.webonise.broadcastsample.InventoryClass;
import com.example.webonise.broadcastsample.InventoryFormActivity;
import com.example.webonise.broadcastsample.MainActivity;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {

    public final static String CUSTOM_INTENT = "com.example.ACTION_LOGOUT";
    public static final String user="user";
    public static final String userlogin="userlogin";
    public static final String inventory="inventory";

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
            InventoryClass inventoryClass = bundle.getParcelable(inventory);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:

                SharedPreferences sharedPreferences = getSharedPreferences(user, 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(userlogin, false);
                edit.commit();
                broadcastIntent();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void broadcastIntent() {
        Intent intentBroadcast = new Intent();
        intentBroadcast.setAction(CUSTOM_INTENT);
        sendBroadcast(intentBroadcast);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InventoryFormActivity.class);
        startActivity(intent);
    }

}
