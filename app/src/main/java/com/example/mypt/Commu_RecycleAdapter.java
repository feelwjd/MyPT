package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.ShareVO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Commu_RecycleAdapter extends RecyclerView.Adapter<Commu_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<ShareVO> shareVOList;


    public Commu_RecycleAdapter(Context c, List<ShareVO> shareVOList) {
        this.c = c;
        this.shareVOList = shareVOList;

    }

    @NonNull
    @Override
    public Commu_RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.activity_community_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Commu_RecycleAdapter.MyViewHolder holder, int position) {


        holder.userid.setText(shareVOList.get(position).getUserid());
        String imgUrl = shareVOList.get(position).getImage();
        String mypt = "http://3.34.96.177:8000/shareimage/";
        String result = mypt.concat(imgUrl);
        Picasso.get().load(result).into(holder.image_s);
        holder.commudescript.setText(shareVOList.get(position).getCommudescript());
        holder.heart.setText(String.valueOf(shareVOList.get(position).getHeart()));

    }


    @Override
    public int getItemCount() {
        return shareVOList.size();
    }

    public void  filterList(List<ShareVO> filteredList) {
        shareVOList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
        //TextView commuid;
        ImageView image_s;
        TextView commudescript;
        TextView heart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = (TextView)itemView.findViewById(R.id.userid);
            //commuid = (TextView)itemView.findViewById(R.id.commuid);

            image_s = (ImageView)itemView.findViewById(R.id.image_s);
            commudescript = (TextView)itemView.findViewById(R.id.commudescript);
            heart = (TextView)itemView.findViewById(R.id.heart);


        }
    }

}

