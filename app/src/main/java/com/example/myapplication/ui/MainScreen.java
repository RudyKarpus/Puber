package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void searching(View v)
    {
        Intent i=new Intent(this, PubberSearcher.class);

        /* Po co to?
        test = new ArrayList<>();
        test.add("nie");
        i.putStringArrayListExtra("ocena", (ArrayList<String>) test);
         */
        startActivity(i);
    }
}