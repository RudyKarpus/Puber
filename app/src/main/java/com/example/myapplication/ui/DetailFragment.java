package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.util.SliderAdapter;
import com.example.myapplication.data.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment
{
    private ViewPager2 viewPager;

    public DetailFragment() {super(R.layout.detail);}

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        viewPager=requireView().findViewById(R.id.viewPager);
        List<SliderItem> slideritems=new ArrayList<>();
        slideritems.add(new SliderItem(R.drawable.otwarte));
        slideritems.add(new SliderItem(R.drawable.zamkniete));
        viewPager.setAdapter(new SliderAdapter(slideritems,viewPager));

    }

}