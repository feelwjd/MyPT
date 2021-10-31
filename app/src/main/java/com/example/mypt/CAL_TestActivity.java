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
    //private static final String TAG = "test";
    //public static final int LOAD_SUCCESS = 101;

    List<CAL_Data> dataInfo;
    RecyclerView recyclerView;
    CAL_RecycleAdapter recycleAdapter;

    //private String REQUEST_URL = Config.APIROUTINEINFO; // 여기가 젤 중요한 부분인데 Config 파일의 모델을 사용함. 내용은 Config 파일 참고할것.

    //private ProgressDialog progressDialog;
    //private TextView textviewJSONText;
    //private TextView textView;
    //Data data;
    //RoutineInfoResult routineInfoResult;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tt);
        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        JsonObject jsonObject = new JsonObject("feelwjd");
        CAL_RetrofitService retrofitService = CAL_APIClient.getClient().create(CAL_RetrofitService.class);
        Call<List<CAL_Data>> call = retrofitService.getData(jsonObject);




        call.enqueue(new Callback<List<CAL_Data>>()
        {
            @Override
            public void onResponse(Call<List<CAL_Data>> call, Response<List<CAL_Data>> response) {

                String date="20";
                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;
                recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body(),date);
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<CAL_Data>> call, Throwable t) {
                Log.d("TestActivity",t.toString());
            }
        });

    }
}
