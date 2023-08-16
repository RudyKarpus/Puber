package com.example.myapplication.util;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interface.SelectListener;
import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.PubData;

import java.util.ArrayList;
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
        ImageButton imageButton;
        List<String> s=new ArrayList<>();
        private static final String FILE_NAME="saved.txt";

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
            imageButton=(ImageButton)itemView.findViewById(R.id.heart);
            imageButton.setTag(R.drawable.heartempty);



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
    public void onBindViewHolder(@NonNull PubViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nazwa.setText(pubData.get(position).getName());
        holder.ocenaJakosc.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaKoszty.setText(pubData.get(position).getName());
        holder.czasOtwarcia.setText(pubData.get(position).getRatingGoogle()+"");
        holder.ocenaGoogle.setText(pubData.get(position).getName());
        holder.czasAuto.setText(pubData.get(position).getPrice());
        holder.czasPieszo.setText(pubData.get(position).getPrice());
        holder.image.setImageResource(pubData.get(position).getImage());



        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            String  load;
            @Override
            public void onClick(View v) {
                if((Integer)holder.imageButton.getTag()==R.drawable.heartempty)
                {
                    holder.imageButton.setImageResource(R.drawable.heartfull);
                    holder.imageButton.setTag(R.drawable.heartfull);
                    load=AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue();
                    if(load!=null)
                    {
                        load=load+pubData.get(position).getId();
                        AppContainer.getInstance().getPubSearchingContainer().getSavedlist().setValue(load);
                    }
                    else
                    {
                        AppContainer.getInstance().getPubSearchingContainer().getSavedlist().setValue(load);
                    }
                    }
                else
                {

                    holder.imageButton.setImageResource(R.drawable.heartempty);
                    holder.imageButton.setTag(R.drawable.heartempty);
                    load=AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue();
                    load=load.replace(pubData.get(position).getId()+"-","");
                    AppContainer.getInstance().getPubSearchingContainer().getSavedlist().setValue(load);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return pubData.size();
    }




}
