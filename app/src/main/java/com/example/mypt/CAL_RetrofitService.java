package com.example.mypt;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CAL_RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/routine-info")
    //Call<Map<String,Object>> getData(@FieldMap HashMap<String, Object> param);
    //Call<TestItem> getData(@FieldMap HashMap<String, String> param);
    //Call<TestItem> getData(@Query("userid") String userid);
    Call<List<CAL_Data>> getData(@Body JsonObject jsonObject);

}
