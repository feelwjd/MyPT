package com.example.mypt.commu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommunityVO {
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

    @SerializedName("heart")
    @Expose
    private int heart;

    @SerializedName("commudescript")
    @Expose
    private String commudescript;

    @SerializedName("commuid")
    @Expose
    private String commuid;

    @SerializedName("image")
    @Expose
    private String image;


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getUserid() {
        return userid;
    }

    public String getcommudescript() {
        return commudescript;
    }

    public String getcommuid() {
        return commuid;
    }

    public String getimaget() { return image; }

    public int getheart() {
        return heart;
    }


}