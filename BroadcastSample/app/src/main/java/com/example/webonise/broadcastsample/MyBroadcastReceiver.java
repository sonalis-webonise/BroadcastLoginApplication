package com.example.webonise.broadcastsample;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by webonise on 22/9/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //String action=intent.getAction();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.ACTION_LOGOUT");
        Log.v("Message", "Logging out from broadcast");
        Toast.makeText(context, "Sample Intent", Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences=context.getSharedPreferences("user",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("userlogin",false);
        editor.commit();
//        boolean loginStatus=false;
//        intent.putExtra("loginStatus",false);

//        Intent intentHome = new Intent(this, MainActivity.class);
//        startActivity(intentHome);


//        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);

    }
}
