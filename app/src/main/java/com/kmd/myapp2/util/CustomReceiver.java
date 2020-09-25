package com.kmd.myapp2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.kmd.myapp2.BuildConfig;
import com.kmd.myapp2.R;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown_action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "power_connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage ="power_disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "custom_broadcast_toast";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
