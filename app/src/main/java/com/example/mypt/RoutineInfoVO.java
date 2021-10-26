package com.example.mypt;

import java.util.ArrayList;

public class RoutineInfoVO extends ArrayList<RoutineInfoVO> {
    private String userid;
    private int routineid;
    private int UserRoutineId;
    private String RoutineDate;
    private String Time;
    private ArrayList<Integer> workoutid;
    private String routinename;
    private String description;
    private ArrayList<String> workoutname;

    public String getUserid(){
        return userid;
    }
    public void setUserid(){
        this.userid=userid;
    }

    public int getRoutineid(){
        return routineid;
    }
    public void setRoutineid(){
        this.routineid = routineid;
    }

    public int getUserRoutineId(){
        return UserRoutineId;
    }
    public void setUserRoutineId(){
        this.UserRoutineId = UserRoutineId;
    }

    public String getRoutineDate(){
        return RoutineDate;
    }
    public void setRoutineDate(){
        this.RoutineDate = RoutineDate;
    }

    public String getTime(){
        return Time;
    }
    public void setTime(){
        this.Time = Time;
    }

    public ArrayList<Integer> getWorkoutid(){
        return workoutid;
    }
    public void setWorkoutid(ArrayList<Integer> workoutid){
        this.workoutid = workoutid;
    }

    public String getRoutinename(){
        return routinename;
    }
    public void setRoutinename(){
        this.routinename = routinename;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(){
        this.description = description;
    }

    public ArrayList<String> getWorkoutname(){
        return workoutname;
    }
    public void setWorkoutname(ArrayList<String> workoutname){
        this.workoutname = workoutname;
    }

    @Override
    public String toString(){
        return "ROUTINEINFO{"+
                "userid='" + userid + '\'' +

                ", routineid='" + routineid + '\'' +

                ", UserRoutineId='" + UserRoutineId + '\'' +

                ", RoutineDate='" + RoutineDate + '\'' +

                ", Time='" + Time + '\'' +

                ", workoutid=" + workoutid +

                ", routinename='" + routinename + '\'' +

                ", description='" + description + '\'' +

                ", workoutname='" + workoutname +

                '}';
    }
}
