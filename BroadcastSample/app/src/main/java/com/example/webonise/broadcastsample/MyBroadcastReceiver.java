package com.example.webonise.broadcastsample;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by webonise on 22/9/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Toast.makeText(context,"Sample Intent",Toast.LENGTH_LONG).show();

//        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);

    }
}
