package com.example.gui_components_prac_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    boolean dirtyDark = false;
    boolean dirtyRate = false;
    int progressLength = 0;
    Button btn, getRating;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switchBtn = findViewById(R.id.switch1);
//        ProgressBar progress = findViewById(R.id.progressBar);
        ImageView imgView = findViewById(R.id.imageView2);
        TextClock clock = findViewById(R.id.textClock);
        btn = findViewById(R.id.button1);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
            startActivity(intent);
        });

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!dirtyDark){
                    dirtyDark = true;
                    progressLength+=20;
//                    progress.setProgress(progressLength);
                }else{
                    progressLength+=10;
//                    progress.setProgress(progressLength);
                }
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    imgView.setColorFilter(getResources().getColor(R.color.white));
                    clock.setTextColor(Color.parseColor("white"));
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    imgView.setColorFilter(getResources().getColor(R.color.black));
                    clock.setTextColor(Color.parseColor("black"));
                }
            }
        });

        boolean darkModeOn = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        switchBtn.setChecked(darkModeOn);
        if(darkModeOn){
            switchBtn.setText("Dark Mode");
        }else{
            switchBtn.setText("Light Mode");
        }

//        Log.i("Progress", " = " + progressLength);

        getRating = findViewById(R.id.getRating);
        ratingBar = findViewById(R.id.ratingBar);
        getRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating is :" + ratingBar.getRating();
                Toast.makeText(MainActivity.this, rating, Toast.LENGTH_LONG).show();
            }
        });



    }
}