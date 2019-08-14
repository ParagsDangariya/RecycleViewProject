package com.example.recycleviewproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.ViewHolder>{

    private ArrayList<Pokemon> pokearray;
    private Context c;
    private  View.OnClickListener pokelistner;

    public Recycleadapter(ArrayList<Pokemon> pokearray, Context c) {
        this.pokearray = pokearray;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(c).asBitmap().load(pokearray.get(position).getPimg()).into(holder.imgv);
        holder.txtv.setText(pokearray.get(position).getPname());

    }
    public void setOnClickListner(View.OnClickListener onClickListner){
        pokelistner = onClickListner;
    }

    @Override
    public int getItemCount() {
        return pokearray.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgv;
        TextView txtv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgv = itemView.findViewById(R.id.pimage);

            txtv = itemView.findViewById(R.id.pname);
            itemView.setTag(this);
            itemView.setOnClickListener(pokelistner);
        }
    }
}
