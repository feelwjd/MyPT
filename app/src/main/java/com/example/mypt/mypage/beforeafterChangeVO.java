package com.example.mypt.mypage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class beforeafterChangeVO {

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("weight")
    @Expose
    private int weight;

    @SerializedName("height")
    @Expose
    private int height;
}
