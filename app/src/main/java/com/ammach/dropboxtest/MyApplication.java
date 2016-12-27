package com.ammach.dropboxtest;

import android.app.Application;

import com.cloudrail.si.CloudRail;

/**
 * Created by ammach on 11/17/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CloudRail.setAppKey("582dc12f228a9a552392f1b2");
    }
}
