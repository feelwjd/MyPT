package com.example.mypt.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class workoutVO {
    @SerializedName("workoutid")
    @Expose
    private int workoutid;

    @SerializedName("part")
    @Expose
    private String part;

    @SerializedName("workoutname")
    @Expose
    private String workoutname;

    @SerializedName("workoutclass")
    @Expose
    private String workoutclass;

    public int getWorkoutid() { return workoutid; }

    public String getPart() {return part;}

    public String getWorkoutname() {
        return workoutname;
    }

    public String getWorkoutclass() { return workoutclass; }
}
