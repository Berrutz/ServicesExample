package com.example.servicesexample.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.servicesexample.services.ForegroundService;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        /*if(intent.getAction().equals(intent.ACTION_BOOT_COMPLETED)) // all'avvio telefono fare questo
            context.startForegroundService(new Intent(context, ForegroundService.class));*/
        if(intent.getAction().equals(intent.ACTION_AIRPLANE_MODE_CHANGED)) // all'avvio telefono fare questo
            context.startForegroundService(new Intent(context, ForegroundService.class));
    }
}
