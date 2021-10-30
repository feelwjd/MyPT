package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.CommunityVO;

import java.util.List;

public class Community_RecycleAdapter extends RecyclerView.Adapter<Community_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<CommunityVO> dataList;

    public Community_RecycleAdapter(Context c, List<CommunityVO> dataList) {
        this.c = c;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.activity_community_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userid.setText(dataList.get(position).getUserid());
        holder.heart.setText(dataList.get(position).getheart());
        holder.commudescript.setText(dataList.get(position).getcommudescript());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
        TextView heart;
        TextView commudescript;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = (TextView)itemView.findViewById(R.id.userid);
            heart = (TextView)itemView.findViewById(R.id.heart);
            commudescript = (TextView)itemView.findViewById(R.id.commudescript);


        }
    }
}
