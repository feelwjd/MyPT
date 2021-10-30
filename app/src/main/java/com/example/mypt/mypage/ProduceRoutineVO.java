package com.example.mypt.mypage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProduceRoutineVO {

    @SerializedName("workoutid")
    @Expose
    private int workoutid;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("routinename")
    @Expose
    private String routinename;
}
