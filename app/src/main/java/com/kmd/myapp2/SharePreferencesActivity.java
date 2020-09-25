package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharePreferencesActivity extends AppCompatActivity {
    public static final String SHARE_PREFS_NAME = "com.kmd.myapp2";
    private TextView txtValueRead;
    private EditText txtKeyEntry, txtValueEntry;
    private Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFS_NAME, MODE_PRIVATE);

        txtValueRead = (TextView) findViewById(R.id.txtValueRead);
        txtKeyEntry = (EditText) findViewById(R.id.txtKeyEntry);
        txtValueEntry = (EditText) findViewById(R.id.txtValueEntry);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // KEY, VALUE
                editor.putString(txtKeyEntry.getText().toString(), txtValueEntry.getText().toString());
                editor.apply();
                Toast.makeText(getBaseContext(), "Saved to share pref", Toast.LENGTH_LONG).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String afterRead = sharedPreferences.getString(txtKeyEntry.getText().toString(),"");
                txtValueRead.setText(afterRead);
            }
        });

    }
}