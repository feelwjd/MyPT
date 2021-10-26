package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class RoutineInfoResult {
    @SerializedName("userid")
    private String userid;

    @SerializedName("routineid")
    private int routineid;

    @SerializedName("UserRoutineId")
    private int UserRoutineId;

    @SerializedName("RoutineDate")
    private String RoutineDate;

    @SerializedName("Time")
    private String Time;

    @SerializedName("workoutid")
    private String workoutid;

    @SerializedName("routinename")
    private String routinename;

    @SerializedName("description")
    private String description;

    @SerializedName("workoutname")
    private String workoutname;

    public String getUserid() {
        return userid;
    }

    public int getRoutineid() {
        return routineid;
    }

    public int getUserRoutineId() {
        return UserRoutineId;
    }

    public String getRoutineDate() {
        return RoutineDate;
    }

    public String getTime() {
        return Time;
    }

    public String getWorkoutid() {
        return workoutid;
    }

    public String getRoutinename() {
        return routinename;
    }

    public String getDescription() {
        return description;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    @Override
    public String toString(){
        return "{"+
                "userid"+userid+
                ",routineid"+routineid+
                ",UserRoutineId"+UserRoutineId+
                ",RoutineDate"+RoutineDate+
                ",Time"+Time+
                ",workoutid"+workoutid+
                ",routinename"+routinename+
                ",description"+description+
                ",workoutname"+workoutname+
                '}';
    }
}
