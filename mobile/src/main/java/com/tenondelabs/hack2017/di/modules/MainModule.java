package com.tenondelabs.hack2017.di.modules;

import android.content.Context;

import com.tenondelabs.hack2017.data.remote.TenondeApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Module
public class MainModule {

//    private final AkibuscaApplication akibuscaApplication;
//
//    public MainModule(AkibuscaApplication akibuscaApplication) {
//        this.akibuscaApplication = akibuscaApplication;
//    }
//
//    @Provides
//    @Singleton
//    public Context provideApplicationContext() {
//        return akibuscaApplication;
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
        return Realm.getDefaultInstance();
    }

}