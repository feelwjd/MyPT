package com.example.mypt.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class userVO {
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("pw")
    @Expose
    private String pw;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("height")
    @Expose
    private float height;

    @SerializedName("weight")
    @Expose
    private float weight;

    @SerializedName("sex")
    @Expose
    private int sex;

    @SerializedName("image")
    @Expose
    private String image;

    public String getUserid() {
        return userid;
    }

    public String getPw() {
        return pw;
    }

    public String getUsername() {
        return username;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getSex() {
        return sex;
    }

    public String getImage() {
        return image;
    }
}
