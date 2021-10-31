package com.example.mypt.commu;

import com.google.gson.annotations.SerializedName;

public class ShareObject {
    @SerializedName("userid")
    private String userid;
    @SerializedName("commudescript")
    private String commudescript ;

    public ShareObject(String userid,String commudescript) {
        this.userid = userid;
        this.commudescript  = commudescript ;
    }
}
