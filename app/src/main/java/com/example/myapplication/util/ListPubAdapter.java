package com.example.myapplication.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.PubData;

import java.util.List;

import lombok.Getter;

public class ListPubAdapter extends RecyclerView.Adapter<ListPubAdapter.PubViewHolder> {

    private List<PubData> pubData;
    @Getter
    public static  class  PubViewHolder extends RecyclerView.ViewHolder{

        TextView nazwa;
        TextView czasOtwarcia;
        TextView czasAuto;
        TextView czasPieszo;
        TextView ocenaJakosc;
        TextView ocenaKoszty;
        TextView ocenaGoogle;
        TextView ocenaInna;

        ImageView image;

        public PubViewHolder(@NonNull View itemView) {
            super(itemView);
            nazwa=(TextView) itemView.findViewById(R.id.nazwaPubu);
            ocenaJakosc =(TextView) itemView.findViewById(R.id.ocenaJakosc);
            ocenaKoszty =(TextView) itemView.findViewById(R.id.ocenaKoszty);
            czasOtwarcia=(TextView) itemView.findViewById(R.id.czasOtwarcia);
            ocenaGoogle=(TextView) itemView.findViewById(R.id.ocenaGoogle);
            ocenaInna=(TextView) itemView.findViewById(R.id.ocenaInna);
            image=(ImageView) itemView.findViewById(R.id.PubImage);
            czasAuto =(TextView) itemView.findViewById(R.id.drogaAuto);
            czasPieszo =(TextView) itemView.findViewById(R.id.drogaPieszo);
        }
    }
    public ListPubAdapter(List<PubData> pubData)
    {
        this.pubData=pubData;
    }
    @NonNull
    @Override
    public PubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PubViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pub_recycler_view_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PubViewHolder holder, int position) {
        holder.nazwa.setText(pubData.get(position).getName());
        holder.ocenaJakosc.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaKoszty.setText(pubData.get(position).getName());
        holder.czasOtwarcia.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaGoogle.setText(pubData.get(position).getName());
        holder.ocenaInna.setText(pubData.get(position).getRatingGoogle()+"");
        holder.czasAuto.setText(pubData.get(position).getPrices());
        holder.czasPieszo.setText(pubData.get(position).getPrices());
        holder.image.setImageResource(pubData.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return pubData.size();
    }


}
