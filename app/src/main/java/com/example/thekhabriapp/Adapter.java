package com.example.thekhabriapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass>modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context,webView.class);
        intent.putExtra("url",modelClassArrayList.get(position).getUrl());
context.startActivity(intent);
    }
});
holder.mpublished.setText("Published At->"+modelClassArrayList.get(position).getPublishedAt());
holder.mheading.setText("Published At->"+modelClassArrayList.get(position).getTitle());
holder.mcontent.setText("Published At->"+modelClassArrayList.get(position).getDescription());
holder.mauthor.setText("Published At->"+modelClassArrayList.get(position).getAuthor());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);





    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mpublished;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            mauthor=itemView.findViewById(R.id.author);
            mcontent=itemView.findViewById(R.id.content);
            mpublished=itemView.findViewById(R.id.time);
            cardView=itemView.findViewById(R.id.cardview);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
