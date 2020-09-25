package com.kmd.myapp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int MY_FIRST_CODE = 1;
    private EditText txtfirst, txtsecond;
    private TextView txtResult;
    private Button btnok, btnsecond, btnbrowse, btndial, btnrecycler, btnAsync,
            btnSharePrefs, btnDialog,btnNetwork, btnHTTPClient, btnDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, ImageAndOtherActivity.class));
            }
        });


        txtfirst = (EditText) findViewById(R.id.txtfirst);
        txtsecond = (EditText) findViewById(R.id.txtsecond);
        txtResult = (TextView) findViewById(R.id.txtresult);
        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( txtfirst.getText().toString().equals(txtsecond.getText().toString())){
                    txtResult.setText("Same");
                }else{
                    txtResult.setText("Difference");
                }
            }
        });


        btnsecond = (Button) findViewById(R.id.btnsecond);
        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data1", txtfirst.getText().toString());
                intent.putExtra("data2", txtsecond.getText().toString());
                startActivityForResult(intent, MY_FIRST_CODE);
            }
        });

        btnbrowse = (Button) findViewById(R.id.btnbrowse);
        btnbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btndial = (Button) findViewById(R.id.btndial);
        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:091234567");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnrecycler = (Button) findViewById(R.id.btnrecycler);
        btnrecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyRecyclerView.class);
                startActivity(intent);
            }
        });

        btnAsync = (Button) findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AndroidThreadActivity.class);
                startActivity(intent);
            }
        });

        btnSharePrefs = (Button) findViewById(R.id.btnSharePrefs);
        btnSharePrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SharePreferencesActivity.class);
                startActivity(intent);
            }
        });

        btnDialog = (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new
                        AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Connect to Provider");
                alertDialog.setMessage("This is my message");
                //alertDialog.setView();
                alertDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
                //alertDialog.setNegativeButton()
//                alertDialog.setNeutralButton()
            }
        });

        btnNetwork = (Button) findViewById(R.id.btnNetwork);
        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NetworkInfoActivity.class);
                startActivity(intent);
            }
        });

        btnHTTPClient = (Button) findViewById(R.id.btnHTTPConnection);
        btnHTTPClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getBaseContext(), MyHTTPClientConnectionActivity.class);
                startActivity(intent);
            }
        });

        btnDatabase = (Button) findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getBaseContext(), DatabaseEntryActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_FIRST_CODE) { // Identify activity
            if (resultCode == RESULT_OK) { // Activity succeeded
                String reply = data.getStringExtra("reply");
                txtResult.setText("Reply: " + reply);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}