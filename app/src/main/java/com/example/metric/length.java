package com.example.metric;

import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class length extends AppCompatActivity {
    TextView View1, View2, View3,View4,View5,View6,View7,View8;
    EditText editTextNumber;
    private static final DecimalFormat DF = new DecimalFormat();
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
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

            View1.setText("In Km");
            View3.setText("In Mt");
            View5.setText("In foot");
            View7.setText("In inches");

            double input =Double.parseDouble(editTextNumber.getText().toString());
            double inches = Math.round((input * 63360) * 100.0) / 100.0;
            double feet = Math.round((input * 5280) * 100.0) / 100.0;
            double meters = Math.round((input * 1609.3) * 100.0) / 100.0;
            double kiloMeters = Math.round((input * 1.6) * 100.0) / 100.0;
           

            View2.setText(String.valueOf(kiloMeters) + "km");
            View4.setText(String.valueOf(meters) + "m");
            View6.setText(String.valueOf(feet) + "feet");
            View8.setText(String.valueOf(inches) + "inch");
        });
    }

}
