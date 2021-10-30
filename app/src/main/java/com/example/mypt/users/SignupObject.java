package com.example.mypt.users;

import com.google.gson.annotations.SerializedName;

public class SignupObject {
    @SerializedName("userid")
    private String userid;
    private String pw;
    private String username;
    private float height;
    private float weight;
    private int sex;
    private String image;

    public SignupObject(String userid,String pw, String username, float height, float weight, int sex){
        this.userid = userid;
        this.pw = pw;
        this.username = username;
        this.height = height;
        this.weight = weight;
        this.sex = sex;

    }
}
