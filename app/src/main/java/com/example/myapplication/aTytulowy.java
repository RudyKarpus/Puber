package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;


public class aTytulowy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atytulowy);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i=new Intent(aTytulowy.this,bWybor.class);
                startActivity(i);

            }
        }, 5000);
    }



}