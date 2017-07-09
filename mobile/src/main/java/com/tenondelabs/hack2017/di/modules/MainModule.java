package com.tenondelabs.hack2017.di.modules;

import android.content.Context;

import com.tenondelabs.hack2017.TenondeLabsApplication;
import com.tenondelabs.hack2017.data.remote.TenondeApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
@Module
public class MainModule {

//    private TenondeLabsApplication application;
//
//    public MainModule(TenondeLabsApplication application) {
//        this.application = application;
//    }
//
//    @Provides
//    @Singleton
//    public Context provideApplicationContext() {
//        return application;
//    }

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }

    @Provides
    @Singleton
    public TenondeApiClient provideApiClient() {
        return new TenondeApiClient();
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(context)
                .name("myrealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getDefaultInstance();
    }

}