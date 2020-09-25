package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NetworkInfoActivity extends AppCompatActivity {

    private Button btnIsConnect, btnIsMobile, btnIsWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_info);

        btnIsConnect = (Button) findViewById(R.id.btnIsConnect);
        btnIsMobile = (Button) findViewById(R.id.btnIsMobile);
        btnIsWifi = (Button) findViewById(R.id.btnIsWifi);

        final ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        btnIsConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    Toast.makeText(getBaseContext(), "Network connected", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "No network connected", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnIsMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkInfo networkInfo =
                        connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (networkInfo != null && networkInfo.isConnected()) {
                    Toast.makeText(getBaseContext(), "Network is mobile", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Network not mobile", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnIsWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkInfo networkInfo =
                        connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (networkInfo != null && networkInfo.isConnected()) {
                    Toast.makeText(getBaseContext(), "Network is wifi", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Network not wifi", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}