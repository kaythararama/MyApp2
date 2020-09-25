package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.kmd.myapp2.util.CustomReceiver;

public class MyBroadcastActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broadcast);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(mReceiver, filter);

        // Register the receiver to receive custom broadcast.
//        LocalBroadcastManager.getInstance(this).registerReceiver
//                (mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        // Unregister the receivers.
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}