package com.example.mypt.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SigninVO {
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("pw")
    @Expose
    private String pw;

    @SerializedName("weight")
    @Expose
    private float weight;

    public String getUserid() {
        return userid;
    }

    public String getPw() {
        return pw;
    }

    public float getWeight() {
        return weight;
    }
}
