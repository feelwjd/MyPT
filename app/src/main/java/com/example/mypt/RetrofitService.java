package com.example.mypt;

import com.example.mypt.RoutineInfoResult;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @FormUrlEncoded
    @POST("api/routine-info")
    Call<TestItem> getData(@FieldMap HashMap<String, Object> param);
}
