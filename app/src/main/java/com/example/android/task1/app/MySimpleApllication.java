package com.example.android.task1.app;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

/**
 * Created by world on 2018/02/09.
 */

public class MySimpleApllication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("LxAfr65hQcssLZ5b65umoCk1H", "J81MH2Un9PO3ALMAQMGfXfmCKh5E2GxFyb0pRZ8xM4R86h8yrD"))
                .debug(true)
                .build();
        Twitter.initialize(config);
    }
}
