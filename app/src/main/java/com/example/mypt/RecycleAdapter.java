package com.example.mypt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.RoutineInfoVO;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<RoutineInfoVO> routineInfoVOList;

    public RecycleAdapter(Context c, List<RoutineInfoVO> routineInfoVOList) {
        this.c = c;
        this.routineInfoVOList = routineInfoVOList;
    }

    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {

        holder.userid.setText(routineInfoVOList.get(position).getUserid());
        holder.routineid.setText(String.valueOf(routineInfoVOList.get(position).getRoutineid()));
        holder.UserRoutineId.setText(String.valueOf(routineInfoVOList.get(position).getUserRoutineId()));
        holder.RoutineDate.setText((CharSequence) routineInfoVOList.get(position).getRoutineDate());
        holder.Time.setText(routineInfoVOList.get(position).getTime());
        holder.workoutid.setText(routineInfoVOList.get(position).getWorkoutid());
        holder.routinename.setText(routineInfoVOList.get(position).getRoutinename());
        holder.description.setText(routineInfoVOList.get(position).getDescription());
        holder.workoutname.setText(routineInfoVOList.get(position).getWorkoutname());

    }

    @Override
    public int getItemCount() {
        int i = 1;
        return i;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
        TextView routineid;
        TextView UserRoutineId;
        TextView RoutineDate;
        TextView Time;
        TextView workoutid;
        TextView routinename;
        TextView description;
        TextView workoutname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userid = (TextView)itemView.findViewById(R.id.userid);
            routineid = (TextView)itemView.findViewById(R.id.routineid);
            UserRoutineId = (TextView)itemView.findViewById(R.id.UserRoutineId);
            RoutineDate = (TextView)itemView.findViewById(R.id.RoutineDate);
            Time = (TextView)itemView.findViewById(R.id.Time);
            workoutid = (TextView)itemView.findViewById(R.id.workoutid);
            routinename = (TextView)itemView.findViewById(R.id.routinename);
            description = (TextView)itemView.findViewById(R.id.description);
            workoutname = (TextView)itemView.findViewById(R.id.workoutname);


        }
    }
}
