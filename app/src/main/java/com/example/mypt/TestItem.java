package com.example.mypt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestItem {
    @SerializedName("body")
    @Expose
    public List<Data> body;

}
