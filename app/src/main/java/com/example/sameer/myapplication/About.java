package com.example.sameer.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class About extends AppCompatActivity {










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.About_Title);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }




}
