package com.example.mypt;

import com.example.mypt.api.workoutVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface My_RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/workout")
    Call<List<workoutVO>> getWorkout();
}
