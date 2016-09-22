package com.example.webonise.broadcastsample;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by webonise on 20/9/16.
 */
public class MyApplicationConfig extends Application implements RealmMigration {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .migration(this)
                .schemaVersion(2)
                .build();
        Realm.setDefaultConfiguration(config);
    }

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

    }
}
