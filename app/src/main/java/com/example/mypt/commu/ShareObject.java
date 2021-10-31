package com.example.mypt.commu;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

public class ShareObject {
    @SerializedName("userid")
    private String userid;
    @SerializedName("commudescript")
    private String commudescript ;
    @SerializedName("image")
    private Image image;

    public ShareObject(String userid,String commudescript, Image image) {
        this.userid = userid;
        this.commudescript  = commudescript ;
        this.image  = image ;
    }
}
