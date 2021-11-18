package com.example.dailies;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Vr5n4Mq2YbDMAXoHa7vPbCfxLguC1Ls3pv2LOv2Z")
                .clientKey("tqcrB2TgexmfxZ3zqaOkNpmUeqgoJwbFR3XmyPh6")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
