package com.example.mypt;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    String title;



    @SerializedName("data")
    String bodypost;


    public PostModel(String post1, String title){
        this.title = title;
        this.title= bodypost;

    }
}
