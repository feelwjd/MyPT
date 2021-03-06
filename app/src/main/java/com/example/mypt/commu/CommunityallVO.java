package com.example.mypt.commu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunityallVO {
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
}