package com.example.deviceroation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
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
        Log.i(TAG,"onCreate");

        //setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.user_info_fragment_frame,new LoginFragment(),"LoginFragment").commit();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new MainActivityViewModel();

        final Intent intent = new Intent(this,MyForegroundService.class);

        MainActivityViewModel.ActivityServices activityServices = new MainActivityViewModel.ActivityServices() {
            @Override
            public void startForegroundServiceFromActivity() {
                Intent intn = new Intent(intent);
                ContextCompat.startForegroundService(MainActivity.this,intn);
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//                    startForegroundService(intn);
//                    //startService(intn);
//                }
//                else {
//                    startService(intn);
//                }
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
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
//        final Intent intent = new Intent(this,MyForegroundService.class);
//        startService(intent);
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }


    class DownloadTask extends AsyncTask<Void,Integer,String>{

        public DownloadTask() {
        }

        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }
    }
}
