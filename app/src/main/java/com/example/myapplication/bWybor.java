package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class bWybor extends AppCompatActivity {

    private List<String> test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bwybor);
    }

    public void dalej(View v)
    {
        Intent i=new Intent(this, cPubber.class);

        test = new ArrayList<String>();
        test.add("nie");
        i.putStringArrayListExtra("ocena", (ArrayList<String>) test);
        startActivity(i);
    }
}