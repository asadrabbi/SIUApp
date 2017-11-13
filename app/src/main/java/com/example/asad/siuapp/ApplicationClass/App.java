package com.example.asad.siuapp.ApplicationClass;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by SHOBOJIT on 9/26/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() { 
        super.onCreate();
        Fresco.initialize(this);


    }

}