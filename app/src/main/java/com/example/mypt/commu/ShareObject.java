package com.example.mypt.commu;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.List;

public class ShareObject {
    @SerializedName("userid")
    private String userid;
    @SerializedName("commudescript")
    private String commudescript ;
    @SerializedName("image")
    private File image;

    @SerializedName("userroutineid")
    private int userroutineid;

    public String getUserid() {
        return userid;
    }

    public String getCommudescript() {
        return commudescript;
    }

    public File getImage() {
        return image;
    }

    public int getUserroutineid() {
        return userroutineid;
    }

    public ShareObject(String userid, String commudescript, int userroutineid) {
        this.userid = userid;
        this.commudescript  = commudescript ;
        //this.image  = image ;
        this.userroutineid = userroutineid;
    }
}
