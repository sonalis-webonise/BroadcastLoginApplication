package com.example.webonise.loginapplication;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by webonise on 22/9/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Toast.makeText(context,"Intent",Toast.LENGTH_LONG).show();
        //PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);

    }
}
