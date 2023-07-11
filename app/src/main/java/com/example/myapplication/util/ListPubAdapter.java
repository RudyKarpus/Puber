package com.example.myapplication.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interface.SelectListener;
import com.example.myapplication.R;
import com.example.myapplication.data.PubData;

import java.util.List;

import lombok.Getter;

public class ListPubAdapter extends RecyclerView.Adapter<ListPubAdapter.PubViewHolder> {

    private List<PubData> pubData;
    public SelectListener selectlistener;
    @Getter
    public static  class  PubViewHolder extends RecyclerView.ViewHolder{

        TextView nazwa;
        TextView czasOtwarcia;
        TextView czasAuto;
        TextView czasPieszo;
        TextView ocenaJakosc;
        TextView ocenaKoszty;
        TextView ocenaGoogle;

        ImageView image;

        public PubViewHolder(@NonNull View itemView,SelectListener selectlistener) {
            super(itemView);
            nazwa=(TextView) itemView.findViewById(R.id.nazwaPubu);
            ocenaJakosc =(TextView) itemView.findViewById(R.id.ocenaJakosc);
            ocenaKoszty =(TextView) itemView.findViewById(R.id.ocenaKoszty);
            czasOtwarcia=(TextView) itemView.findViewById(R.id.czasOtwarcia);
            ocenaGoogle=(TextView) itemView.findViewById(R.id.ocenaGoogle);
            image=(ImageView) itemView.findViewById(R.id.PubImage);
            czasAuto =(TextView) itemView.findViewById(R.id.drogaAuto);
            czasPieszo =(TextView) itemView.findViewById(R.id.drogaPieszo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectlistener!=null)
                    {
                        int pos=getAdapterPosition();

                        if(pos!=RecyclerView.NO_POSITION)
                        {
                            selectlistener.onItemClicked(pos);
                        }
                    }
                }
            });
        }
    }
    public ListPubAdapter(List<PubData> pubData,SelectListener selectlistener) {this.pubData=pubData;this.selectlistener=selectlistener;}
    @NonNull
    @Override
    public PubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PubViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pub_recycler_view_row,viewGroup,false),selectlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull PubViewHolder holder, int position) {
        holder.nazwa.setText(pubData.get(position).getName());
        holder.ocenaJakosc.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaKoszty.setText(pubData.get(position).getName());
        holder.czasOtwarcia.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaGoogle.setText(pubData.get(position).getName());
        holder.czasAuto.setText(pubData.get(position).getPrice());
        holder.czasPieszo.setText(pubData.get(position).getPrice());
        holder.image.setImageResource(pubData.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return pubData.size();
    }


}
