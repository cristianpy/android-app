package com.tenondelabs.hack2017.di.modules;

import android.support.v4.app.Fragment;

import com.tenondelabs.hack2017.helpers.EventBus;
import com.tenondelabs.hack2017.helpers.GreenRobotEventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Module
public class LibsModule {

    private Fragment fragment;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus provideEvenBus() {
        return new GreenRobotEventBus();
    }

//    @Provides
//    @Singleton
//    ImageLoader provideImageLoader(Fragment fragment) {
//        return new GlideImageLoader(fragment);
//    }

    @Provides
    @Singleton
    Fragment provideFragment() {
        return this.fragment;
    }

}
