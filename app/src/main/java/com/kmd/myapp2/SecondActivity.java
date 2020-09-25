package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt;
    private Button btnResult;
    private EditText txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt = (TextView) findViewById(R.id.textView);
        txtResult = (EditText) findViewById(R.id.txtresult);
        btnResult = (Button) findViewById(R.id.btnresult);

        // extracting data from Main Activity
        Bundle bundle = getIntent().getExtras();
        if( bundle !=null ){
            String data1 = bundle.getString("data1");
            String data2 = bundle.getString("data2");
            txt.setText("D1: "+data1 + ", D2: " + data2 );
        }

        // sending data to main Activity
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("reply", txtResult.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}