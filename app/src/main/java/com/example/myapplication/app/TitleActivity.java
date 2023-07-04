package com.example.myapplication.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent i=new Intent(TitleActivity.this, MainActivity.class);
            startActivity(i);

        }, 5000);
    }



}