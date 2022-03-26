package com.example.metric;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class temp extends AppCompatActivity {
    TextView View1, View2, View3,View4;
    private EditText editNumber;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_temp);
        View1 = findViewById(R.id.textView1);
        View2 = findViewById(R.id.textView2);
        View3 = findViewById(R.id.textView3);
        View4 = findViewById(R.id.textView4);
        editNumber = findViewById(R.id.editTextNumber);
        
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            View1.setText("In Celsius");
            View3.setText("In Kelvin");
            double inputValue =Double.parseDouble(editNumber.getText().toString());
            double celsius=(inputValue -32)*5/9;
            double kelvin=celsius+273.15;
            celsius=Math.round(celsius * 100.0) / 100.0;
            kelvin=Math.round(kelvin * 100.0) / 100.0;
            View2.setText(String.valueOf(celsius) + "degree C");
            View4.setText(String.valueOf(kelvin) + "degree K");
        });
    }
}