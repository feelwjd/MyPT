package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class Login_JsonObject {
    @SerializedName("userid")
    private String userid;

    @SerializedName("pw")
    private String pw;

    public Login_JsonObject(String userid, String pw){
        this.userid = userid;
        this.pw = pw;
    }

}
