package com.example.practical4_;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;
    TextView outTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button1);
        edt = findViewById(R.id.editText1);
        outTv = findViewById(R.id.textViewOutput);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra("Input", edt.getText().toString());
            startActivity(intent);
        });

        Intent response = getIntent();

        edt.setText(response.getStringExtra("input"));
        outTv.setText(response.getStringExtra("output"));
    }
}