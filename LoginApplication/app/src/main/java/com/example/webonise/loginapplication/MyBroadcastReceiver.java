package com.example.webonise.loginapplication;

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

    public static final String userlogin = "userlogin";
    public static final String user = "user";
    public static final String CUSTOM_INTENT = "com.example.ACTION_LOGOUT";
    public static final String intentMessage = "Login Application Receiver Intent";

    @Override
    public void onReceive(Context context, Intent intent) {
        //String action = intent.getAction();
        if (intent.getAction().equalsIgnoreCase(CUSTOM_INTENT)) {
            //PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);
            Log.v("Message", "Logging out from login");
            Toast.makeText(context, intentMessage, Toast.LENGTH_LONG).show();

            SharedPreferences sharedPreferences = context.getSharedPreferences(user, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(userlogin, false);
            editor.commit();
        }

    }
}
