package com.example.mypt.mypage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class beforeafterVO {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    private int status;
    @SerializedName("success")
    private boolean success;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    private String image;

    public beforeafterVO() {

        this.image = image;

    }

}
