package com.example.mypt.mypage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteRoutineVO {

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("routineid")
    @Expose
    private String routineid;
}
