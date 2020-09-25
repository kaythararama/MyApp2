package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kmd.myapp2.model.database.MyDatabaseRepository;
import com.kmd.myapp2.model.entity.Person;

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
                Person person = new Person(txtFirstName.getText().toString(), txtLastName.getText().toString());
                MyDatabaseRepository.getInstance(getBaseContext())
                        .getMyDatabase()
                        .personDao()
                        .insert(person);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Person> personList = MyDatabaseRepository.getInstance(getBaseContext())
                        .getMyDatabase()
                        .personDao().findAll();
                txtData.setText("");
                for( Person p : personList){
                    txtData.append(p.getFirstName()+" "+p.getLastName()+"\n");
                }
            }
        });
    }
}