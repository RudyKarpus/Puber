package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.PubData;
import com.example.myapplication.util.SliderAdapter;
import com.example.myapplication.data.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment
{
    private ViewPager2 viewPager;

    private TextView t;

    public DetailFragment() {super(R.layout.detail);}

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        viewPager=requireView().findViewById(R.id.viewPager);
        List<SliderItem> slideritems=new ArrayList<>();
        slideritems.add(new SliderItem(R.drawable.zdjecie1));
        slideritems.add(new SliderItem(R.drawable.zdjecie3));
        slideritems.add(new SliderItem(R.drawable.zdjecie1));
        slideritems.add(new SliderItem(R.drawable.zdjecie3));
        viewPager.setAdapter(new SliderAdapter(slideritems,viewPager));
        invsible();

    }

    private void invsible()
    {
        t=requireView().findViewById(R.id.googleR);
        t.setVisibility(View.GONE);
        t=requireView().findViewById(R.id.fbR);
        t.setVisibility(View.GONE);
        t=requireView().findViewById(R.id.tripR);
        t.setVisibility(View.GONE);
    }

    public void visible(View v)
    {
        TextView t=requireView().findViewById(R.id.googleR);
        t.setVisibility(View.VISIBLE);
        t=requireView().findViewById(R.id.fbR);
        t.setVisibility(View.VISIBLE);
        t=requireView().findViewById(R.id.tripR);
        t.setVisibility(View.VISIBLE);
    }



}