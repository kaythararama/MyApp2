package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ImageAndOtherActivity extends AppCompatActivity {

    private RadioButton radioButton1, radioButton2;
    private CheckBox checkBox1;
    private Switch switch1;
    private ToggleButton toggleButton;
    private EditText txtok;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_other);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        switch1 = (Switch) findViewById(R.id.switch1);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        txtok = (EditText) findViewById(R.id.txtok);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                txtok.setText("Is checked=" + b);
//                Toast.makeText(ImageAndOtherActivity.this, "Is checked=" + b, Toast.LENGTH_SHORT).show();

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                txtok.setText("Is checked=" + b);
//                Toast.makeText(ImageAndOtherActivity.this, "Is switch=" + b, Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                txtok.setText("Is toggle=" + b);
//                Toast.makeText(ImageAndOtherActivity.this, "Is toggle=" + b, Toast.LENGTH_SHORT).show();
            }
        });




        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this, R.array.mobile,
                        android.R.layout.simple_spinner_item);


        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                txtok.setText("Is toggle=" + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onRadioButtonClick(View view){
        if( view.getId() == R.id.radioButton1){
            radioButton1 = (RadioButton) view;
            txtok.setText("I am " + radioButton1.getText().toString()+". Checked=" + radioButton1.isChecked());
//            Toast.makeText(ImageAndOtherActivity.this, "I am " + radioButton1.getText().toString()+". Checked=" + radioButton1.isChecked(), Toast.LENGTH_SHORT).show();
        }else if( view.getId() == R.id.radioButton2){
            radioButton2 = (RadioButton) view;
            txtok.setText("I am " + radioButton2.getText().toString()+". Checked=" + radioButton2.isChecked());
//            Toast.makeText(ImageAndOtherActivity.this, "I am " + radioButton2.getText().toString()+". Checked=" + radioButton2.isChecked(), Toast.LENGTH_SHORT).show();
        }
    }
}