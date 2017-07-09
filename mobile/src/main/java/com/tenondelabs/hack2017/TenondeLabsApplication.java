package com.tenondelabs.hack2017;

import android.app.Application;
import android.content.Context;

import com.tenondelabs.hack2017.data.remote.OkClientFactory;
import com.twitter.sdk.android.core.Twitter;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;

/**
 * Created by rorogarcete on 08/07/17.
 */

public class TenondeLabsApplication extends Application {

    public Context context;
    private static TenondeLabsApplication mInstance = null;
    private OkHttpClient mOkHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);

        mInstance = this;
        mOkHttpClient = OkClientFactory.provideOkHttpClient(this);
        initRealmConfiguration();
    }

    public static TenondeLabsApplication getInstance() {
        return mInstance;
    }

    private void initDependency() {

    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    private void initRealmConfiguration() {
        // The Realm file will be located in Context.getFilesDir() with name "default.realm"
//        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
//        Realm.setDefaultConfiguration(config);

        // The RealmConfiguration is created using the builder pattern.
        // The Realm file will be located in Context.getFilesDir() with name "myrealm.realm"
//        RealmConfiguration config = new RealmConfiguration.Builder(context)
//                .name("myrealm.realm")
//                .encryptionKey(getKey())
//                .schemaVersion(42)
//                .modules(new MySchemaModule())
//                .migration(new MyMigration())
//                .build();
        // Use the config
//        Realm realm = Realm.getInstance(config);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("myrealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
