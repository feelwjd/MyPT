package com.example.mypt.users;

import com.google.gson.annotations.SerializedName;

public class SigndelObject {
    @SerializedName("userid")
    private String userid;

    public SigndelObject(String userid){
        this.userid = userid;
    }
}
