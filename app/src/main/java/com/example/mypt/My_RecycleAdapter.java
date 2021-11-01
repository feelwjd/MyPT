package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.workoutVO;

import java.util.List;


public class My_RecycleAdapter extends RecyclerView.Adapter<My_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<workoutVO> workoutVOList;

    public My_RecycleAdapter(Context c, List<workoutVO> workoutVOList) {
        this.c = c;
        this.workoutVOList = workoutVOList;
    }

    @NonNull
    @Override
    public My_RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.layout_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_RecycleAdapter.MyViewHolder holder, int position) {

      //  holder.workoutid.setText(String.valueOf(workoutVOList.get(position).getWorkoutid()));
        holder.workoutname.setText(workoutVOList.get(position).getWorkoutname());
//        holder.part.setText(workoutVOList.get(position).getPart());
//        holder.dclass.setText(String.valueOf(workoutVOList.get(position).getWorkoutclass()));
        //holder.Time.setText(workoutVOList.get(position).getTime());
        //holder.workoutid.setText(workoutVOList.get(position).getWorkoutid());
        //holder.routinename.setText(workoutVOList.get(position).getRoutinename());
        //holder.description.setText(workoutVOList.get(position).getDescription());
        //holder.workoutname.setText(workoutVOList.get(position).getWorkoutname());

    }

    @Override
    public int getItemCount() {
        return workoutVOList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        int i=0;
        ImageView redheart;
    //    TextView workoutid;
        TextView workoutname;
//        TextView part;
//        TextView dclass;
        //TextView Time;
        //TextView workoutid;
        //TextView routinename;
        //TextView description;
        //TextView workoutname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            redheart = (ImageView) itemView.findViewById(R.id.redheart);
        //    workoutid = (TextView)itemView.findViewById(R.id.workoutid);
            workoutname = (TextView)itemView.findViewById(R.id.rv_favorites);
//            part = (TextView)itemView.findViewById(R.id.part);
//            dclass = (TextView)itemView.findViewById(R.id.dclass);
            //Time = (TextView)itemView.findViewById(R.id.Time);
            //workoutid = (TextView)itemView.findViewById(R.id.workoutid);
            //routinename = (TextView)itemView.findViewById(R.id.routinename);
            //description = (TextView)itemView.findViewById(R.id.description);
            //workoutname = (TextView)itemView.findViewById(R.id.workoutname);

            redheart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i=1-i;
                    if(i==0){
                        redheart.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    } else{
                        redheart.setImageResource(R.drawable.ic_like);

                    }
                }

            });
        }
    }
}