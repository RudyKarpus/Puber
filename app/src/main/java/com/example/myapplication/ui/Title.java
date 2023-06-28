package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent i=new Intent(Title.this, MainScreen.class);
            startActivity(i);

        }, 5000);
    }



}