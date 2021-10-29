package com.example.mypt.users;

import com.google.gson.annotations.SerializedName;

public class SigndelObject {
    @SerializedName("userid")
    private String userid;
    private String pw;

    public SigndelObject(String userid, String pw){
        this.userid = userid;
        this.pw = pw;
    }
}
