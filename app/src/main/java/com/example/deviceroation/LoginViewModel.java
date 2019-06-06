package com.example.deviceroation;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class LoginViewModel extends BaseObservable {
    private String userName;
    private String password;

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public void login(){

    }
}
