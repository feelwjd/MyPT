package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class JsonObject {
    @SerializedName("userid")
    private String userid;

    public JsonObject(String userid){
        this.userid = userid;
    }
}
