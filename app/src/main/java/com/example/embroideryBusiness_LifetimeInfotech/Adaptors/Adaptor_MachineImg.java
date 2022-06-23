package com.example.embroideryBusiness_LifetimeInfotech.Adaptors;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.embroideryBusiness_LifetimeInfotech.R;
import com.example.embroideryBusiness_LifetimeInfotech.SellMachineDetail;

import java.io.File;
import java.util.ArrayList;

public class Adaptor_MachineImg extends RecyclerView.Adapter<Adaptor_MachineImg.ViewHolder> {

ArrayList<Uri>uriArrayList;
Activity activity;


    public Adaptor_MachineImg(SellMachineDetail sellMachineDetail, ArrayList<Uri> uri) {
        this.activity=sellMachineDetail;
        this.uriArrayList=uri;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(activity).inflate(R.layout.item_imgview,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.item_idImgview.setImageURI(uriArrayList.get(position));
        Log.e("List---1---", "onBindViewHolder: "+uriArrayList.get(position) );

        Glide.with(activity)
                .load(uriArrayList.get(position)).placeholder(R.drawable.ic_launcher_background)

                .into(holder.item_idImgview);



    }

    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount------------: "+ uriArrayList.size() );

        return uriArrayList.size();



    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView item_idImgview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_idImgview=itemView.findViewById(R.id.item_idImgview);
            
        }
    }
}
