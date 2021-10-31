package com.example.mypt;

import com.example.mypt.api.workoutVO;
import com.example.mypt.mypage.beforeafterObject;
import com.example.mypt.mypage.beforeafterVO;
import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface My_RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/workout")
    Call<List<workoutVO>> getWorkout();

    @Headers("Content-Type: application/json")
    @POST("mypage/beforeafterObject")
    Call<beforeafterVO> getbeforeafter(@Body beforeafterObject beforeafterObject);
}
