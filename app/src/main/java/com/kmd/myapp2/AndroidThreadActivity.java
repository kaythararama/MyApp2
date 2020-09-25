package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kmd.myapp2.util.SimpleAsyncTask;

public class AndroidThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_thread);

        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        SimpleAsyncTask simpleAsyncTask = new SimpleAsyncTask(txtResult, getBaseContext());
        simpleAsyncTask.execute("Hello.txt");
    }

}