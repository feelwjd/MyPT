package com.example.mypt.commu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Community_Data {
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("commudescript")
    @Expose
    private String commudescript;

    @SerializedName("heart")
    @Expose
    private int heart;

    public String getUserid() {
        return userid;
    }

    //
    public String getCommudescript() {
        return commudescript;
    }
//

    public int getHeart() {
        return heart;
    }


}