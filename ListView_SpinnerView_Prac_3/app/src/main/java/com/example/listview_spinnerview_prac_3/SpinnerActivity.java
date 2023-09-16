package com.example.listview_spinnerview_prac_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ArrayList<String> courses = new ArrayList<>(), description = new ArrayList<>();
    Button btnBack, btnAdd, btnRemove;
    TextView descTv;

    int cnt = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = findViewById(R.id.spinner);

        btnBack = findViewById(R.id.buttonBack);
        btnAdd = findViewById(R.id.buttonAdd);
        btnRemove = findViewById(R.id.buttonRemove);
        descTv = findViewById(R.id.textViewDescription);


        courses.add("Select course");
        courses.add("MOS");
        courses.add("ADF");
        courses.add("CC");
        courses.add("BDA");
        courses.add("RSM");
        courses.add("AE");

        description.add("Please select a course for details");
        description.add("Mobile Operating System\n\nThis course is about understanding iOS and Android and developing applications for these OS and ...");
        description.add("Application Development Framework\n\nDjango che bas...");
        description.add("Compiler Construction\n\nAlmost THOC jevu...");
        description.add("Big Data Analytics\n\nAll about Hadoop...");
        description.add("Road Safety and Management\n\nEasy elective for good marks :) ...");
        description.add("Arduino for Engineers\n\nInventor feeling when designing circuits and coding...");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(SpinnerActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btnAdd.setOnClickListener(view -> {
            String course = "New Course " + cnt;
            String desc = "New Description " + cnt++ + "...";
            courses.add(course);
            description.add(desc);
            Toast.makeText(view.getContext(), course + " added successfully", Toast.LENGTH_LONG).show();
        });

        btnRemove.setOnClickListener(view -> {
            String course = courses.get(courses.size()-1);
            String desc = description.get(description.size()-1);
            courses.remove(course);
            description.remove(desc);
            Toast.makeText(view.getContext(), course + " removed successfully", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        if(i == 0) return;
        String courseName = parent.getItemAtPosition(i).toString();
        if(i < description.size()){
            descTv.setText(description.get(i));
        }
        Toast.makeText(parent.getContext(), "Course Selected: " + courseName, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}