package com.wingshield.technologies.demopostdata.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import androidx.multidex.MultiDex;


import com.google.firebase.FirebaseApp;

import java.util.UUID;

/**
 * Created by Arun Kumar on 14/6/20.
 * Copyright (c) 2020 wing shield technologies.com All rights reserved.
 */

public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();
    public static final String VERSION = "1.2.0";
    public static final String APP_ID = "DBCA8310-4EFD-411F-ADC7-854BF850A7EB";
    private static AppController mInstance;
   // private RequestQueue mRequestQueue;
    private SharedPreferences sharedPreferences;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


   /* public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);

    }

    public void cancelPendingRequests(String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
*/
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    /*public <T> void addToRequestQueue(Request<T> req) {
        if (isOnline()) {
            req.setRetryPolicy(new DefaultRetryPolicy(
                    60000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            req.setTag(TAG);
            getRequestQueue().add(req);
            getRequestQueue().getCache().clear();
        }
    }*/



}
