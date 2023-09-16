package com.example.listview_spinnerview_prac_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnL, btnS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnL = findViewById(R.id.buttonList);
        btnS = findViewById(R.id.buttonSpinner);

        btnL.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        btnS.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intent);
        });
    }
}