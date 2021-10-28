package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.api.workoutVO;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<workoutVO> workoutVOList;

    public RecycleAdapter(Context c, List<workoutVO> workoutVOList) {
        this.c = c;
        this.workoutVOList = workoutVOList;
    }

    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {

        holder.workoutid.setText(String.valueOf(workoutVOList.get(position).getWorkoutid()));
        holder.workoutname.setText(workoutVOList.get(position).getWorkoutname());
        holder.part.setText(workoutVOList.get(position).getPart());
        holder.dclass.setText(String.valueOf(workoutVOList.get(position).getWorkoutclass()));
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

        TextView workoutid;
        TextView workoutname;
        TextView part;
        TextView dclass;
        //TextView Time;
        //TextView workoutid;
        //TextView routinename;
        //TextView description;
        //TextView workoutname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            workoutid = (TextView)itemView.findViewById(R.id.workoutid);
            workoutname = (TextView)itemView.findViewById(R.id.workoutname);
            part = (TextView)itemView.findViewById(R.id.part);
            dclass = (TextView)itemView.findViewById(R.id.dclass);
            //Time = (TextView)itemView.findViewById(R.id.Time);
            //workoutid = (TextView)itemView.findViewById(R.id.workoutid);
            //routinename = (TextView)itemView.findViewById(R.id.routinename);
            //description = (TextView)itemView.findViewById(R.id.description);
            //workoutname = (TextView)itemView.findViewById(R.id.workoutname);


        }
    }
}
