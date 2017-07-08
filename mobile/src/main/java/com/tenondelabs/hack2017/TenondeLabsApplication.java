package com.tenondelabs.hack2017;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;

/**
 * Created by rorogarcete on 08/07/17.
 */

public class TenondeLabsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }
}
