package com.example.mypt;

import com.example.mypt.api.RoutineInfoVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/routine-info")
    Call<List<RoutineInfoVO>> getData(@Body JsonObject jsonObject);
}
