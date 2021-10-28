package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class WorkoutData {
    @SerializedName("workoutid")
    private int workoutid;

    @SerializedName("part")
    private String part;

    @SerializedName("workoutname")
    private String workoutname;

    @SerializedName("class")
    private int dclass;

    public int getWorkoutid() {
        return workoutid;
    }

    public String getPart() {
        return part;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public int getDclass() {
        return dclass;
    }
}
