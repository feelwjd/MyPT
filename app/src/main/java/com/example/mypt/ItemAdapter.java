/*package com.example.mypt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<RoutineInfoVO> list;

    class MyHolder{
        TextView userid;
        TextView routineid;
        TextView UserRoutineId;
        TextView RoutineDate;
        TextView Time;
        TextView workoutid;
        TextView routinename;
        TextView description;
        TextView worktoutname;
    }
    public ItemAdapter(Context context, ArrayList<RoutineInfoVO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int i){
        return list.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        MyHolder myHolder;
        RoutineInfoVO routineInfoVO = list.get(i);
        if(view == null){
            view = View.inflate(context,R.layout.item_list,null);
            myHolder = new MyHolder();
            myHolder.userid = view.findViewById(R.id.userid);
            myHolder.routineid = view.findViewById(R.id.routineid);
            myHolder.UserRoutineId = view.findViewById(R.id.UserRoutineId);
            myHolder.RoutineDate = view.findViewById(R.id.RoutineDate);
            myHolder.Time = view.findViewById(R.id.Time);
            myHolder.workoutid = view.findViewById(R.id.workoutid);
            myHolder.routinename = view.findViewById(R.id.routinename);
            myHolder.description = view.findViewById(R.id.description);
            myHolder.worktoutname = view.findViewById(R.id.workoutname);
            view.setTag(myHolder);
        }
        else{
            myHolder = (MyHolder)view.getTag();
        }
        myHolder.userid.setText(routineInfoVO.getUserid());
        myHolder.routineid.setText(routineInfoVO.getRoutineid());
        myHolder.UserRoutineId.setText(routineInfoVO.getUserRoutineId());
        myHolder.RoutineDate.setText(routineInfoVO.getRoutineDate());
        myHolder.Time.setText(routineInfoVO.getTime());
        myHolder.workoutid.setText((CharSequence) routineInfoVO.getWorkoutid());
        myHolder.routinename.setText(routineInfoVO.getRoutinename());
        myHolder.description.setText(routineInfoVO.getDescription());
        myHolder.worktoutname.setText((CharSequence) routineInfoVO.getWorkoutname());
        return view;
    }
}
*/