package com.example.mypt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyAPICall {

    // http://3.34.96.177:8000/               api/user-routine

        @GET("api/user-routine")
    Call<Datamodel> getData();

}
