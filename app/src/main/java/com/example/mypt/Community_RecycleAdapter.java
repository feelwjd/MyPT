package com.example.mypt;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.Community_Data;
import com.example.mypt.commu.ShareVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Community_RecycleAdapter extends RecyclerView.Adapter<Community_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<ShareVO> shareVOList;

    public Community_RecycleAdapter(Context c, List<ShareVO> shareVOList) {
        this.c = c;
        this.shareVOList = shareVOList;
    }

    @NonNull
    @Override
    public  Community_RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.activity_community_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userid.setText(shareVOList.get(position).getUserid());
        holder.commudescript.setText(shareVOList.get(position).getCommudescript());
        holder.heart.setText(String.valueOf(shareVOList.get(position).getHeart()));
        String imgUrl = shareVOList.get(position).getImage();
        String mypt = "http://3.34.96.177:8000/shareimage/";
        String result = mypt.concat(imgUrl);
        Picasso.get().load(result).into(holder.after);
    }

    @Override
    public int getItemCount() { return shareVOList.size(); }

    public void  filterList(List<ShareVO> filteredList) {
        shareVOList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
        TextView heart;
        TextView commudescript;
        ImageView redheart, comment, after;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = (TextView) itemView.findViewById(R.id.userid);
            heart = (TextView) itemView.findViewById(R.id.heart);
            commudescript = (TextView) itemView.findViewById(R.id.commudescript);
            redheart = (ImageView) itemView.findViewById(R.id.redheart);
            comment = (ImageView) itemView.findViewById(R.id.comment);
            after = (ImageView) itemView.findViewById(R.id.after);

            setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }




    }
}
