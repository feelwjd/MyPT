package com.example.mypt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.commu.ShareVO;
import com.example.mypt.commu.ShareVO;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<ShareVO> shareVOList;


    public RecycleAdapter(Context c, List<ShareVO> shareVOList) {
        this.c = c;
        this.shareVOList = shareVOList;

    }

    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {


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

