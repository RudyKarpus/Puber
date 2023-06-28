package com.example.myapplication.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.PubData;

import java.util.List;

public class Adapter extends ArrayAdapter<PubData>
{
    public Adapter(Context context, int resource, List<PubData> pubDataList)
    {
        super(context,resource, pubDataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        PubData pubData =getItem(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.pubbercell,parent,false);
        }



        TextView nazwa=(TextView) convertView.findViewById(R.id.PubName);
        TextView ocena=(TextView) convertView.findViewById(R.id.PubOcena);
        TextView cena=(TextView) convertView.findViewById(R.id.PubOcenaCena);
        ImageView image=(ImageView) convertView.findViewById(R.id.PubImage);
        ImageView imagegodzine=(ImageView) convertView.findViewById(R.id.ImageOtwarcie);

        nazwa.setText(pubData.getName());
        ocena.setText(pubData.getRatingGoogle()+"");
        cena.setText(pubData.getPrices());
        image.setImageResource(pubData.getImage());

        imagegodzine.setImageResource(R.drawable.otwarte);


        return convertView;



    }
}
