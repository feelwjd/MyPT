package com.example.mypt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.workoutVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class My_TestActivity extends AppCompatActivity {
    //private static final String TAG = "test";
    //public static final int LOAD_SUCCESS = 101;
    // TestItem dataList;
    List<workoutVO> workoutVOList;
    //  List<RoutineInfoVO> aaa;
    RecyclerView recyclerView;
    My_RecycleAdapter recycleAdapter;

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
        setContentView(R.layout.activity_list);

        setContentView(R.layout.activity_popup);



        workoutVOList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //HashMap<String ,String> input = new HashMap<>();
        //input.put("userid","dbehdgns118");

        //JsonObject jsonObject = new JsonObject("feelwjd");
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        My_RetrofitService retrofitService = APIClient.getClient().create(My_RetrofitService.class);   // 서버연결
        Call<List<workoutVO>> call = retrofitService.getWorkout();      // `call 선언
        call.enqueue(new Callback<List<workoutVO>>() {
            @Override
            public void onResponse(Call<List<workoutVO>> call, Response<List<workoutVO>> response) {
                Log.d("Test","success");
                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;
                recycleAdapter = new My_RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<workoutVO>> call, Throwable t) {
                Log.d("TestActivity",t.toString());
            }
        });

    }
    public void Clicked(View view){
        Toast.makeText(getApplicationContext(),"루틴 등록완료", Toast.LENGTH_SHORT);

    }
    public void creatroutine(View view){

    }
}
