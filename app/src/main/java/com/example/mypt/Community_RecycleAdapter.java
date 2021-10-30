package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.Community_Data;

import java.util.ArrayList;
import java.util.List;

public class Community_RecycleAdapter extends RecyclerView.Adapter<Community_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<Community_Data> dataList;

    public Community_RecycleAdapter(Context c, List<Community_Data> dataList) {
        this.c = c;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.activity_community_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userid.setText(dataList.get(position).getUserid());
        holder.heart.setText(dataList.get(position).getHeart());
        holder.commudescript.setText(dataList.get(position).getCommudescript());

    }

    @Override
    public int getItemCount() { return dataList == null ? 0 : dataList.size(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
        TextView heart;
        TextView commudescript;
        ImageView redheart, comment, after;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = (TextView)itemView.findViewById(R.id.userid);
            heart = (TextView)itemView.findViewById(R.id.heart);
            commudescript = (TextView)itemView.findViewById(R.id.commudescript);
            redheart = (ImageView) itemView.findViewById(R.id.redheart);
            comment = (ImageView)itemView.findViewById(R.id.comment);
            after = (ImageView)itemView.findViewById(R.id.after);
        }
    }
}
