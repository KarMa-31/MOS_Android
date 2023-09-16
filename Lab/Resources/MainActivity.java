package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);

        ArrayList<String> listItems = new ArrayList<>();
        listItems.add("CODEFORCES");
        listItems.add("CODECHEF");
        listItems.add("LEETCODE");
        listItems.add("ATCODER");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_layout , R.id.itemTextView , listItems);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView image = (ImageView) findViewById(R.id.image);

                switch (i){
                    case 0 :
                        image.setImageResource(R.drawable.codeforces);
                        break;
                    case 1 :
                        image.setImageResource(R.drawable.codechef);
                        break;
                    case 2 :
                        image.setImageResource(R.drawable.leetcode);
                        break;
                    case 3 :
                        image.setImageResource(R.drawable.atcoder);
                        break;
                    default :
                        System.out.println("Something went wrong.");
                        break;
                }
            }
        });
    }
}