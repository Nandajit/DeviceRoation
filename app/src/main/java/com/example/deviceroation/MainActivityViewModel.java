package com.example.deviceroation;

import android.databinding.BaseObservable;

public class MainActivityViewModel extends BaseObservable {

    private ActivityServices activityServices;

    public void setActivityServices(ActivityServices activityServices){
        this.activityServices = activityServices;
    }

    public void startService(){
        if (activityServices!=null){
            activityServices.startForegroundServiceFromActivity();
        }
    }

    public interface ActivityServices{
        void startForegroundServiceFromActivity();
    }
}
