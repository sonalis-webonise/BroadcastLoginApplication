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

    public static final String user="user";
    public static final String userlogin="userlogin";
    public static final String ReceiveIntent="com.example.webonise.broadcastsample.ACTION_LOGOUT";
    public static final String intentMessage="Broadcast Application Receiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase(ReceiveIntent)) {

            Log.v("Message", "Logging out from broadcast");
            Toast.makeText(context, intentMessage, Toast.LENGTH_LONG).show();
            SharedPreferences sharedPreferences = context.getSharedPreferences(user, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(userlogin, false);
            editor.commit();
        }
    }
}
