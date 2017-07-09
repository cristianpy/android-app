package com.tenondelabs.hack2017.di.modules;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.tenondelabs.hack2017.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
@Module
public class FragmentModule {

    private Fragment fragment;
    private Context context;

    public FragmentModule(Fragment fragment, Context context) {
        this.fragment = fragment;
        this.context = context;
    }

    @Provides
    @PerFragment
    Context provideContext() {
        return this.context;
    }

    @Provides
    @PerFragment
    Fragment provideFragment(){
        return this.fragment;
    }
}
