package com.example.mypt.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SigndelVO {
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("pw")
    @Expose
    private String pw;

    public String getUserid() {
        return userid;
    }

    public String getPw() {
        return pw;
    }
}
