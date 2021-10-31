package com.example.mypt;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostReqeustApi {


    // http://3.34.96.177:8000/               api/user-routine

    @POST("api/user-routine")
    Call<PostModel> PostDataIntoServer(@Body PostModel postModel);

}
