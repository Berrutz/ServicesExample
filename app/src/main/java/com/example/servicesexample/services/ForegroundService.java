package com.example.servicesexample.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.servicesexample.R;

public class ForegroundService extends Service {

    public final String TAG="ForegroundService";
    private static int cont=0;
    private Thread myThread = null;
    private final String NOTIFICATION_CHANNEL_ID = "ForegroundService ID";

    public ForegroundService(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,TAG +" - onStartCommand");
        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Log.i(TAG,"ForegroundService is running - Count : " + cont);
                    cont++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread.start();

        createNotify();

        return super.onStartCommand(intent, flags, startId);
    }

    private void createNotify() {

        NotificationChannel channel=new NotificationChannel(NOTIFICATION_CHANNEL_ID,NOTIFICATION_CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        getSystemService(NotificationManager.class).createNotificationChannel(channel); // creo canale
        Notification.Builder ntf = new Notification.Builder( this,
                NOTIFICATION_CHANNEL_ID      )
                .setContentText(TAG + " IS RUNNING").setContentTitle("SERVICE IS ACTIVE").setSmallIcon(R.drawable.ic_launcher_background);
        startForeground(1001,ntf.build());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
