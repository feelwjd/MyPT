package com.example.mypt;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.commu.CommunityObject;
import com.example.mypt.commu.CommunityVO;
import com.example.mypt.users.SigndelObject;
import com.example.mypt.users.SigndelVO;
import com.example.mypt.users.SigninObject;
import com.example.mypt.users.SigninVO;
import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitService {

    @Headers("Content-Type: application/json")
    @POST("api/routine-info")
    Call<List<RoutineInfoVO>> getData(@Body JsonObject jsonObject);

    @Headers("Content-Type: application/json")
    @POST("users/signin")
    Call<SigninVO> getLogin(@Body SigninObject signinObject);

    //커뮤니티 게시물 전체 불러오기
    @Headers("Content-Type: application/json")
    @POST("commu/share_show_all")
    Call<List<CommunityVO>> getCommunity(@Body CommunityObject communityObject);

    //이미지 따로 업로드
    @Multipart
    @Headers("Content-Type: application/json")
    @POST("users/signup")
    Call<String> getSignup_img(@Part MultipartBody.Part file);

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "http://3.34.96.177:8000/users/signdel", hasBody = true)
    Call<SigndelVO> getSigndel(@Body SigndelObject signdelObject);

    @Headers("Content-Type: application/json")
    @POST("users/signup")
    Call<SignupVO> getSignup(@Body SignupObject signupObject);

}
