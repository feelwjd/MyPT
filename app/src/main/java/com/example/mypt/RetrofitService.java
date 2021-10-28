package com.example.mypt;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.api.workoutVO;
import com.example.mypt.users.SigndelObject;
import com.example.mypt.users.SigndelVO;
import com.example.mypt.users.SigninObject;
import com.example.mypt.users.SigninVO;
import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/routine-info")
    Call<List<RoutineInfoVO>> getData(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("users/signin")
    Call<List<SigninVO>> getLogin(@Body SigninObject signinObject);

    @Headers("Content-Type: application/json")
    @POST("users/signup")
    Call<List<SignupVO>> getSignup(@Body SignupObject signupObject);

    @Headers("Content-Type: application/json")
    @POST("users/signdel")
    Call<List<SigndelVO>> getSigndel(@Body SigndelObject signdelObject);

    @Headers("Content-Type: application/json")
    @POST("api/workout")
    Call<List<workoutVO>> getWorkout();

}
