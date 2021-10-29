package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class JsonObject {
    @SerializedName("userid")
    private String userid;

    public JsonObject(String userid){
        this.userid = userid;
    }
}


// 파싱하려는 데이터를 jsonObject에 형태로 적어준다.