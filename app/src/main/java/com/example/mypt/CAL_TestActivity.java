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
    TestItem dataList;
    List<Data> dataInfo;
    List<Data> aaa;
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;

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
        setContentView(R.layout.activity_test3);
        dataInfo = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //HashMap<String ,String> input = new HashMap<>();
        //input.put("userid","dbehdgns118");

        JsonObject jsonObject = new JsonObject("feelwjd");
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<Data>> call = retrofitService.getData(jsonObject);
        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                Log.d("Test","sex");
                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;
                recycleAdapter = new RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Log.d("TestActivity",t.toString());
            }
        });

    }
}
