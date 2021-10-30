package com.example.mypt;
import android.app.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class APIClient {
    public static String BASE_URL = "http://3.34.96.177:8000/";
    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}

