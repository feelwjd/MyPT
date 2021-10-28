package com.example.mypt.users;

import com.google.gson.annotations.SerializedName;

public class SigninObject {
    @SerializedName("userid")
    private String userid;
    private String pw;

    public SigninObject(String userid,String pw){
        this.userid = userid;
        this.pw = pw;
    }
}
