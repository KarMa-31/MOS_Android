package com.example.gui_components_prac_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

    Button btn1;
    ProgressBar progressBar;
    TextView textView;

    int a;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        btn1 = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView4);

        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
            startActivity(intent);
        });

        a = progressBar.getProgress();
        new Thread(new Runnable() {
            public void run() {
                while (a < 100) {
                    a += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(a);
                            textView.setText(a + "/" + progressBar.getMax());
                            if (a == 100) {
                                textView.setText(" Your Progess has been Completed");

//                                Toast.makeText(view.getContext(), "Please click the rate button to go back to home page", Toast.LENGTH_LONG).show();
//
//                                try {
//                                    Thread.sleep(1500);
//                                } catch (InterruptedException e) {
//                                    throw new RuntimeException(e);
//                                }
                            }
                        }
                    });
                    try {
                        // Sleep for 50 ms to show progress you can change it as well.
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}