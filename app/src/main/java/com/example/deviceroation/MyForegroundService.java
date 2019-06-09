package com.example.deviceroation;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class MyForegroundService extends Service {

    final static String PLAY_ACTION ="com.example.deviceroation.action.play_action";
    final static String PAUSE_ACTION ="com.example.deviceroation.action.pause_action";

    private static final String CHANNEL_ID = "1";

    @Override
    public void onCreate() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"", NotificationManager.IMPORTANCE_DEFAULT);
        }
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getAction().equals(PLAY_ACTION)){

        }
        else if(intent.getAction().equals(PAUSE_ACTION)){

        }
        else {
            Intent playIntent = new Intent(this,MyForegroundService.class);
            playIntent.setAction(PLAY_ACTION);
            PendingIntent playPendingIntent = PendingIntent.getService(this,0,playIntent,0);

            Intent pauseIntent = new Intent(this,MyForegroundService.class);
            pauseIntent.setAction(PAUSE_ACTION);
            PendingIntent pausePendingIntent = PendingIntent.getService(this,0,pauseIntent,0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Hi Title")
                    .setContentText("This is content text")
                    .setShowWhen(true);
            NotificationCompat.Action playAction = new NotificationCompat.Action(R.drawable.play_icon,"play",playPendingIntent);
            NotificationCompat.Action pauseAction = new NotificationCompat.Action(R.drawable.pause_icon,"pause",pausePendingIntent);
            builder.addAction(playAction);
            builder.addAction(pauseAction);
            Notification notification = builder.build();
            startForeground(1,notification);
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
