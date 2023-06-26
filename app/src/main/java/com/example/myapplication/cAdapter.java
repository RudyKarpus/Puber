package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class cAdapter extends ArrayAdapter<cPub>
{
    public cAdapter(Context context, int resource, List<cPub> PubList)
    {
        super(context,resource,PubList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        cPub pub=getItem(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.cpubbercell,parent,false);
        }



        TextView nazwa=(TextView) convertView.findViewById(R.id.PubName);
        TextView ocena=(TextView) convertView.findViewById(R.id.PubOcena);
        TextView cena=(TextView) convertView.findViewById(R.id.PubOcenaCena);
        ImageView image=(ImageView) convertView.findViewById(R.id.PubImage);
        ImageView imagegodzine=(ImageView) convertView.findViewById(R.id.ImageOtwarcie);

        nazwa.setText(pub.getName());
        ocena.setText(pub.getOcenagoog());
        cena.setText(pub.getCena());
        image.setImageResource(pub.getImage());

        imagegodzine.setImageResource(R.drawable.otwarte);


        return convertView;



    }
}
