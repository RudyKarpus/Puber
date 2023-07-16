package com.example.myapplication.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.data.SliderItem;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;

public class SliderAdapter extends  RecyclerView.Adapter<SliderAdapter.SliderViewHolder>
{

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder( SliderViewHolder holder, int position) {
        holder.setImageView(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder
    {
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageSlide);
        }

        void setImageView(SliderItem sliderItem)
        {
            imageView.setImageResource(sliderItem.getImage());
        }
    }
}