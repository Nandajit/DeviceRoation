package com.example.deviceroation;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.deviceroation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Log.d(TAG,"onCrete");
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.user_info_fragment_frame,new UserInputFragment(),"UserInfoFragment").commit();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new MainActivityViewModel();

        final Intent intent = new Intent(this,MyForegroundService.class);

        MainActivityViewModel.ActivityServices activityServices = new MainActivityViewModel.ActivityServices() {
            @Override
            public void startForegroundServiceFromActivity() {
                Intent intn = new Intent(intent);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    startForegroundService(intn);
                    //startService(intn);
                }
                else {
                    startService(intn);
                }
            }
        };

        mainActivityViewModel.setActivityServices(activityServices);
        binding.setMainVM(mainActivityViewModel);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
//        final Intent intent = new Intent(this,MyForegroundService.class);
//        startService(intent);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
