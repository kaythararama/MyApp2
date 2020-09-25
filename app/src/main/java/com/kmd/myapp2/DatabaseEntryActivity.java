package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kmd.myapp2.model.database.MyDatabaseRepository;
import com.kmd.myapp2.model.entity.Person;
import com.kmd.myapp2.util.ReadData;

import java.util.List;

public class DatabaseEntryActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName;
    private TextView txtData;
    private Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_entry);

        txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtData = (TextView) findViewById(R.id.txtData);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SaveData().execute(txtFirstName.getText().toString(), txtLastName.getText().toString());
            }

        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ReadData readData = new ReadData(getBaseContext());
                readData.setListener(new ReadData.ReadDataListener() {
                    @Override
                    public void onResult(List<Person> result) {
                        txtData.setText("");
                        for( Person p : result){
                            txtData.append(p.getFirstName()+" "+p.getLastName()+"\n");
                        }
                    }
                });
                readData.execute();
            }
        });
    }

    private class SaveData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            Person person = new Person(strings[0], strings[1]);
            MyDatabaseRepository.getInstance(getBaseContext())
                    .getMyDatabase()
                    .personDao()
                    .insert(person);

            return null;
        }
    }
}