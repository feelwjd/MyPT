package com.example.mypt.commu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareVO {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    private int status;
    @SerializedName("success")
    private boolean success;
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("commudescript")
    @Expose
    private String commudescript;

    @SerializedName("image")
    @Expose
    private String image;

    public String getUserid() {
        return userid;
    }

    public String getCmmudescript() {
        return commudescript;
    }
    public String getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}