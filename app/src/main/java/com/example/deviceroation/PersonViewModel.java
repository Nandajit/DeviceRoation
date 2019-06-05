package com.example.deviceroation;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class PersonViewModel extends BaseObservable {
    private Person person;

    private String firstName;
    private String lastName;
    private String age;
    private String phoneNumber;

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public PersonViewModel() {
        this.firstName = "ajnjan";
    }

    public void submitUserInfo(){

    }

    public void resetUserInfo(){
        this.setFirstName(null);
        this.lastName = null;
        this.age = null;
        this.phoneNumber = null;
    }
}
