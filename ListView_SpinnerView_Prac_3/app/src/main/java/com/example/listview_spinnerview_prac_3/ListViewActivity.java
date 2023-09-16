package com.example.listview_spinnerview_prac_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> courses = new ArrayList<>(), description = new ArrayList<>();
    TextView descTv;
    ListView l;
    Button btnBack;
//    String[] courses = {"Mobile Operating System", "Application Development Framework", "Compiler Construction",
//            "Big Data Analytics", "Road Safety and Management", "Arduino for Engineers"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        courses.add("");
        courses.add("Mobile Operating System");
        courses.add("Application Development Framework");
        courses.add("Compiler Construction");
        courses.add("Big Data Analytics");
        courses.add("Road Safety and Management");
        courses.add("Arduino for Engineers");

        description.add("Please select a course for details");
        description.add("Mobile Operating System\n\nThis course is about understanding iOS and Android and developing applications for these OS and ...");
        description.add("Application Development Framework\n\nDjango che bas...");
        description.add("Compiler Construction\n\nAlmost THOC jevu...");
        description.add("Big Data Analytics\n\nAll about Hadoop...");
        description.add("Road Safety and Management\n\nEasy elective for good marks :) ...");
        description.add("Arduino for Engineers\n\nInventor feeling when designing circuits and coding...");

        descTv = findViewById(R.id.textViewDescription);
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, courses);

        l.setAdapter(arr);
        l.setOnItemClickListener((adapterView, view, i, l) -> {
            descTv.setText(description.get(i));
        });

        btnBack = findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}