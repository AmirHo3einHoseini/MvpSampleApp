package com.example.mvpsampleapp;

import android.app.Application;
import android.content.Context;

import com.example.mvpsampleapp.data.DataManager;

public class MvpApplication extends Application {
    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = DataManager.getInstance();
    }

    public static MvpApplication get(Context context) {
        return (MvpApplication) context.getApplicationContext();
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
