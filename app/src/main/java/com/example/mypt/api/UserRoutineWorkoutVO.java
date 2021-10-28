package com.example.mypt.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRoutineWorkoutVO {
    @SerializedName("UserRoutineWorkoutId")
    @Expose
    private int UserRoutineWorkoutId;

    @SerializedName("UserRoutineId")
    @Expose
    private int UserRoutineId;

    @SerializedName("workoutid")
    @Expose
    private int workoutid;

    public int getUserRoutineWorkoutId() {
        return UserRoutineWorkoutId;
    }

    public int getUserRoutineId() {
        return UserRoutineId;
    }

    public int getWorkoutid() {
        return workoutid;
    }
}
