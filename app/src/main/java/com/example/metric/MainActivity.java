package com.example.metric;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView View1, View2, View3,View4,View5,View6,View7,View8;
    private EditText editTextNumber;
    private static final DecimalFormat DF = new DecimalFormat();
    private Button button;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor speditor;
    private Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ITEMS, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        sharedPreferences=getSharedPreferences("Metric", MODE_PRIVATE);
        speditor= sharedPreferences.edit();
        speditor.commit();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                speditor.putInt("Metric",i).commit();
                int selectedPref= sharedPreferences.getInt("Metric", MODE_APPEND);

                if (selectedPref == 1){
                    Intent intent = new Intent(MainActivity.this, temp.class);
                    startActivity(intent);
                }
                else if (selectedPref == 2){
                    Intent intent = new Intent(MainActivity.this, length.class);
                    startActivity(intent);
                }
                else if (selectedPref == 3){
                    Intent intent = new Intent(MainActivity.this, weight.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        View1 = findViewById(R.id.textView1);
        View2 = findViewById(R.id.textView2);
        View3 = findViewById(R.id.textView3);
        View4 = findViewById(R.id.textView4);
        View5 = findViewById(R.id.textView5);
        View6 = findViewById(R.id.textView6);
        View7 = findViewById(R.id.textView7);
        View8 = findViewById(R.id.textView8);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            View1.setVisibility(View.VISIBLE);
            View2.setVisibility(View.VISIBLE);
            View3.setVisibility(View.VISIBLE);
            View4.setVisibility(View.VISIBLE);
            View5.setVisibility(View.VISIBLE);
            View6.setVisibility(View.VISIBLE);
            View7.setVisibility(View.VISIBLE);
            View8.setVisibility(View.VISIBLE);

            View1.setText("In Euro");
            View3.setText("In Indian Rupees");
            View5.setText("In Australian Dollar");
            View7.setText("In Canadian Dollar");


            double inputValue =Double.parseDouble(editTextNumber.getText().toString());
            double euro = Math.round(0.91 * inputValue *100.0)/100.0;
            double inr = Math.round((75 * inputValue) * 100.0) / 100.0;
            double aus_dollar = Math.round((1.33 * inputValue) * 100.0) / 100.0;
            double canada_dollar = Math.round((1.25 * inputValue) * 100.0) / 100.0;

            View2.setText(String.valueOf(euro) + "euro");
            View4.setText(String.valueOf(inr) + "inr");
            View6.setText(String.valueOf(aus_dollar) + "$");
            View8.setText(String.valueOf(canada_dollar) + "$");
        });
    }

}