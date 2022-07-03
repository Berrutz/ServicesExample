package com.example.servicesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.example.servicesexample.broadcastreceiver.MyBroadcastReceiver;
import com.example.servicesexample.services.BackgroundService;
import com.example.servicesexample.services.ForegroundService;

public class MainActivity extends AppCompatActivity {

    public final String TAG="MainActivity";
    private MyBroadcastReceiver Mybr=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"ServiceBack start");
        // attivo service in bakcround subito senza bottone
        //startService(new Intent(getApplicationContext(), BackgroundService.class)); // quale classe da avviare  e l'intento
        // startService(new Intent(this, BackgroundService.class));
        //startForegroundService(new Intent(this, ForegroundService.class));

        // Permettono di registrare il Broadcast Receiver
        Mybr = new MyBroadcastReceiver();
        IntentFilter _if = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(Mybr,_if);
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"OnDestroy - " + TAG);
        super.onDestroy();
    }
}