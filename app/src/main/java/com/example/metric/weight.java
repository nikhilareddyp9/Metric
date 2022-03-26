package com.example.metric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class weight extends AppCompatActivity {
    TextView View1, View2, View3,View4,View5,View6;

    private EditText editTextNumber;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        View1 = findViewById(R.id.textView1);
        View2 = findViewById(R.id.textView2);
        View3 = findViewById(R.id.textView3);
        View4 = findViewById(R.id.textView4);
        View5 = findViewById(R.id.textView5);
        View6 = findViewById(R.id.textView6);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            View1.setText("In Kilograms");
            View3.setText("In Ounce");
            View5.setText("Grams");
            double inputValue =Double.parseDouble(editTextNumber.getText().toString());
            double kg = Math.round((0.453 * inputValue) * 100.0) / 100.0;
            double ounce = Math.round((16 * inputValue) * 100.0) / 100.0;
            double grams = Math.round((453.592 * inputValue) * 100.0) / 100.0;
            View2.setText(String.valueOf(kg) + "kg");
            View4.setText(String.valueOf(ounce) + "oz");
            View6.setText(String.valueOf(grams) + "g");
        });
    }
}
