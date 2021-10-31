package com.example.mypt.commu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShareVO {
    @SerializedName("commuid")
    @Expose
    private int commuid;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("commudescript")
    @Expose
    private String commudescript;

    @SerializedName("heart")
    @Expose
    private int heart;


    public int getCommuid() {
        return commuid;
    }

    public String getUserid() {
        return userid;
    }

    public String getImage() {
        return image;
    }

    public String getCommudescript() {
        return commudescript;
    }

    public int getHeart() {
        return heart;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }
}
