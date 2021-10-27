package com.example.mypt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("routineid")
    @Expose
    private int routineid;

    @SerializedName("UserRoutineId")
    @Expose
    private int UserRoutineId;

    @SerializedName("RoutineDate")
    @Expose
    private String RoutineDate;

    @SerializedName("Time")
    @Expose
    private String Time;

    @SerializedName("workoutid")
    @Expose
    private String workoutid;

    @SerializedName("routinename")
    @Expose
    private String routinename;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("workoutname")
    @Expose
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
