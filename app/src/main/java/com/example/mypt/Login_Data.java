package com.example.mypt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login_Data {
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("pw")
    @Expose
    private String RoutineDate;

    public String getUserid() {
        return userid;
    }
    public String getpw() {
        return pw;
    }

}
