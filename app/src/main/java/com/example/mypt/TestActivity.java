package com.example.mypt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.commu.shareVO;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    //private static final String TAG = "test";
    //public static final int LOAD_SUCCESS = 101;

    List<RoutineInfoVO> routineInfoInfoVO;
    RoutineInfoVO routineInfoVO;
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    List<RoutineInfoVO> filterList;
    List<shareVO> shareVOList;
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

        filterList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //HashMap<String ,String> input = new HashMap<>();
        //input.put("userid","dbehdgns118");

        JsonObject jsonObject = new JsonObject("feelwjd");
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<shareVO>> call = retrofitService.getCommu();
        call.enqueue(new Callback<List<shareVO>>() {
            @Override
            public void onResponse(Call<List<shareVO>> call, Response<List<shareVO>> response) {


                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;

                String date1;
                shareVOList = response.body();


                recycleAdapter = new RecycleAdapter(getApplicationContext(), response.body());
                //for (int i = 0;i < response.body().size();i++){
                //    if (response.body().get(i).getRoutineDate().contains(date1)){
                //        filterList.add(response.body().get(i));
                //    }
                //}
                //recycleAdapter.filterList(filterList);
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<shareVO>> call, Throwable t) {
                Log.d("TestActivity", t.toString());
            }
        });

    }

}