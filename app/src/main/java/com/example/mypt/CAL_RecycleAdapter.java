package com.example.mypt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.RoutineInfoVO;

import java.util.Date;
import java.util.List;

public class CAL_RecycleAdapter extends RecyclerView.Adapter<CAL_RecycleAdapter.MyViewHolder>{

    private Context c;
    private List<CAL_Data> dataList;
    private String date;
    private int where;

    public CAL_RecycleAdapter(Context c, List<CAL_Data> dataList,String date) {
        this.c = c;
        this.dataList = dataList;
        this.date = date;

    }

    @NonNull
    @Override
    public CAL_RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.cal_item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CAL_RecycleAdapter.MyViewHolder holder, int position) {



        if (date.equals(dataList.get(position).getRoutineDate())) {
            holder.userid.setText(dataList.get(position).getUserid());
          //  holder.routineid.setText(String.valueOf(dataList.get(position).getRoutineid()));
           // holder.UserRoutineId.setText(String.valueOf(dataList.get(position).getUserRoutineId()));
            holder.RoutineDate.setText(dataList.get(position).getRoutineDate());
           // holder.Time.setText(dataList.get(position).getTime());
           // holder.workoutid.setText(dataList.get(position).getWorkoutid());
           // holder.routinename.setText(dataList.get(position).getRoutinename());
           // holder.description.setText(dataList.get(position).getDescription());
            holder.workoutname.setText(dataList.get(position).getWorkoutname());
            this.where = holder.getAdapterPosition();

        }
        else{
            holder.userid.setText("루틴이 없습니다.");
           // holder.routineid.setText("");
          //  holder.UserRoutineId.setText("");
            holder.RoutineDate.setText("");
           // holder.Time.setText("");
           // holder.workoutid.setText("");
           // holder.routinename.setText("");
           // holder.description.setText("");
            holder.workoutname.setText("");
        }
    }

    @Override
    public int getItemCount() {
        //return 3;

        return dataList.size();
    }

    public void  filterList(List<CAL_Data> filteredList) {
        dataList = filteredList;
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid;
//        TextView routineid;
//        TextView UserRoutineId;
        TextView RoutineDate;
//        TextView Time;
//        TextView workoutid;
//        TextView routinename;
//        TextView description;
        TextView workoutname;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            userid = (TextView)itemView.findViewById(R.id.userid);


//            routineid = (TextView)itemView.findViewById(R.id.routineid);
//            UserRoutineId = (TextView)itemView.findViewById(R.id.UserRoutineId);
            RoutineDate = (TextView)itemView.findViewById(R.id.RoutineDate);
//            Time = (TextView)itemView.findViewById(R.id.Time);
//            workoutid = (TextView)itemView.findViewById(R.id.workoutid);
//            routinename = (TextView)itemView.findViewById(R.id.routinename);
//            description = (TextView)itemView.findViewById(R.id.description);
            workoutname = (TextView)itemView.findViewById(R.id.workoutname);


        }
    }
}
