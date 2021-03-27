package com.example.androiduibasics;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG)
            Timber.plant(new DebugTree());
        Fabric.with(this, new Crashlytics());
        logUser();

    }

    private void logUser() {

        Crashlytics.setUserEmail("panpakr@gmail.com");
        Crashlytics.setUserName("androiduibasics");
        Crashlytics.setUserIdentifier("Id: 1");
    }

}
