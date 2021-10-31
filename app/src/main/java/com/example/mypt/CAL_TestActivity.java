package com.example.mypt;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CAL_TestActivity extends AppCompatActivity{

    List<CAL_Data> dataInfo;

    RecyclerView recyclerView;
    CAL_RecycleAdapter recycleAdapter;

    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_activity_test3);
        dataInfo = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        JsonObject jsonObject = new JsonObject("feel");
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        CAL_RetrofitService retrofitService = CAL_APIClient.getClient().create(CAL_RetrofitService.class);
        Call<List<CAL_Data>> call = retrofitService.getData(jsonObject);
        call.enqueue(new Callback<List<CAL_Data>>() {
            @Override
            public void onResponse(Call<List<CAL_Data>> call, Response<List<CAL_Data>> response) {
                Log.d("Test","sex");

                recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<CAL_Data>> call, Throwable t) {
                Log.d("TestActivity",t.toString());
            }
        });

    }
}
