package com.example.mypt.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRoutineVO {
    @SerializedName("UserRoutineId")
    @Expose
    private int UserRoutineId;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("routineid")
    @Expose
    private int routineid;

    @SerializedName("RoutineDate")
    @Expose
    private String RoutineDate;

    @SerializedName("Time")
    @Expose
    private String Time;

    public int getUserRoutineId() {
        return UserRoutineId;
    }

    public String getUserid() {
        return userid;
    }

    public int getRoutineid() {
        return routineid;
    }

    public String getRoutineDate() {
        return RoutineDate;
    }

    public String getTime() {
        return Time;
    }
}
