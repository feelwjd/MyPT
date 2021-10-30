package com.example.mypt.commu;

import com.google.gson.annotations.SerializedName;

public class CommunityObject {
    @SerializedName("userid")
    private String userid;
    private String image;
    private String commudescript;
    private int heart;

    public CommunityObject(String userid){
        this.userid = userid;
        //this.commudescript = commudescript;
        //this.heart = heart;
    }
}
