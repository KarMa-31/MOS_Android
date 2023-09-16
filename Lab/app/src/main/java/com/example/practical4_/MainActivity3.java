package com.example.practical4_;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btnBack, btn1, btn2;

    TextView inputTv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

//        btnBack = findViewById(R.id.buttonBack);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        inputTv = findViewById(R.id.textViewInput);

        Intent fromAct1 = getIntent();

        char[] input = fromAct1.getStringExtra("Input").toCharArray(), output = new char[input.length];
        System.out.println(input);

        inputTv.setText(String.valueOf(input));

        btn1.setOnClickListener(view -> {
            for(int i=0; i<input.length; i++){
                output[i] = (char)((int)input[i]+1);
            }
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            intent.putExtra("input", String.valueOf(input));
            intent.putExtra("output", String.valueOf(output));

            Toast.makeText(view.getContext(), "Encrypting using Algo-1", Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            startActivity(intent);
        });

        btn2.setOnClickListener(view -> {
            for(int i=0; i<input.length; i++){
                output[i] = (char)((int)input[i]+2);
            }
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            intent.putExtra("input", String.valueOf(input));
            intent.putExtra("output", String.valueOf(output));

            Toast.makeText(view.getContext(), "Encrypting using Algo-2", Toast.LENGTH_LONG).show();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            startActivity(intent);
        });

    }
}