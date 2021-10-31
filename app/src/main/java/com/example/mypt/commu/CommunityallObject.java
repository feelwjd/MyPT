package com.example.mypt.commu;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

public class CommunityallObject {
    @SerializedName("userid")
    private String userid;
//    @SerializedName("image")
//    private Image image;
//    @SerializedName("commudescript")
//    private String commudescript;
//    @SerializedName("heart")
//    private int heart;

    public CommunityallObject(String userid){
        this.userid = userid;

    }
}