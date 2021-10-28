package com.example.mypt;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SignDelete_RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("users/signdel")
        //Call<Map<String,Object>> getData(@FieldMap HashMap<String, Object> param);
        //Call<TestItem> getData(@FieldMap HashMap<String, String> param);
        //Call<TestItem> getData(@Query("userid") String userid);
    Call<CAL_Data> getData(@Body JsonObject jsonObject);
}
