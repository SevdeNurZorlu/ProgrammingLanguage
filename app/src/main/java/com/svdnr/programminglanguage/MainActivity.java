package com.svdnr.programminglanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[],s2[],s3[];

    int[] images = {R.drawable.c, R.drawable.cplus, R.drawable.csharp, R.drawable.java, R.drawable.js, R.drawable.kotlin, R.drawable.phyton, R.drawable.ruby, R.drawable.swift};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        s1=getResources().getStringArray(R.array.programming_language);
        s2=getResources().getStringArray(R.array.decription);
        s3=getResources().getStringArray(R.array.content);
        //main activitden adaptor sınıfına degerleri aktardık
        MyAdapter myAdapter= new MyAdapter(this, s1,s2,s3,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
