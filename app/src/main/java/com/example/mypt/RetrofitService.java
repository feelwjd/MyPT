package com.example.mypt;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.users.SigndelObject;
import com.example.mypt.users.SigndelVO;
import com.example.mypt.users.SigninObject;
import com.example.mypt.users.SigninVO;
import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/routine-info")
    Call<List<RoutineInfoVO>> getData(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("users/signin")
    Call<SigninVO> getLogin(@Body SigninObject signinObject);

    //커뮤니티 게시물 전체 불러오기

    @Headers("Content-Type: application/json")
    @GET("commu/share_show_all")
    Call<List<Community_Data>> getCommunity();

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "http://3.34.96.177:8000/users/signdel", hasBody = true)
    Call<SigndelVO> getSigndel(@Body SigndelObject signdelObject);

    @Headers("Content-Type: application/json")
    @POST("users/signup")
    Call<SignupVO> getSignup(@Body SignupObject signupObject);

    @Headers("Content-Type: application/json")
    @POST("users/signdel")
    Call<SigndelVO> getSigndel(@Body SigndelObject signdelObject);

    @Headers("Content-Type: application/json")
    @GET("commu/share_show_all")

    Call<List<shareVO>> getCommu();
    @POST("commu/share")
    Call<ShareVO> getShare(@Body ShareObject shareObject);

}
