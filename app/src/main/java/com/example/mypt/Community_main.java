package com.example.mypt;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.api.RoutineInfoVO;
import com.example.mypt.commu.Community_Data;
import com.example.mypt.commu.CommunityallObject;
import com.example.mypt.commu.ShareVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Community_main extends AppCompatActivity {
    int i = 0;
    Button btn_upload, btn_mainmenu, btn_f5, btn_timeline;
    List<RoutineInfoVO> routineInfoInfoVO;
    RoutineInfoVO routineInfoVO;
    RecyclerView recyclerView;
    Community_RecycleAdapter recycleAdapter;
    List<RoutineInfoVO> filterList;
    List<ShareVO> shareVOList;

    String[] array;
    Gson gson;

    /**
     * 여기부터 내비바 필요한거
     **/
    public Button btncomu, btncal, btnmy, btnstart;

    /**
     * 여기까지 내비바 필요한거
     **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_main);
        getSupportActionBar().setTitle("커뮤니티");

        int i = 0;
        filterList = new ArrayList<>();
        recyclerView = findViewById(R.id.community_recyclerView);



        JsonObject jsonObject = new JsonObject("feelwjd");

        btn_timeline = (Button) findViewById(R.id.btn_timeline);
        btn_timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sort();
            }
        });

        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Community_UpLoad.class);
                startActivity(intent);
            }
        });

        btn_mainmenu = (Button) findViewById(R.id.btn_mainmenu);
        btn_mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Calender.class);
                startActivity(intent1);
            }
        });

        btn_f5 = (Button) findViewById(R.id.btn_f5);
        btn_f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f5();
            }
        });

        /** 여기부터 내비바 필요한거**/
        btncomu = findViewById(R.id.btncomu);
        btncal = findViewById(R.id.btncal);
        btnmy = findViewById(R.id.btnmy);
        btnstart = findViewById(R.id.btnstart);

        btncomu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Community_main.class);
                startActivity(intent);
            }
        });

        btncal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });

        btnmy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CheckBody.class);
                startActivity(intent);
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Watch.class);
                intent.putExtra("array", array);
                startActivity(intent);
            }
        });
        /** 여기까지 내비바 필요한거**/
    }

    private void f5() {
        //역순
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);

        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<ShareVO>> call = retrofitService.getCommu();
        call.enqueue(new Callback<List<ShareVO>>() {
            @Override
            public void onResponse(Call<List<ShareVO>> call, Response<List<ShareVO>> response) {

                String date1;
                shareVOList = response.body();

                recycleAdapter = new Community_RecycleAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(recycleAdapter);
                Toast.makeText(getApplicationContext(), "로딩 완료!", Toast.LENGTH_SHORT).show();


                }


            @Override
            public void onFailure(Call<List<ShareVO>> call, Throwable t) {
                Log.d("TestActivity", t.toString());

            }
        });
    }

    private void sort() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<ShareVO>> call = retrofitService.getCommu();
        call.enqueue(new Callback<List<ShareVO>>() {
            @Override
            public void onResponse(Call<List<ShareVO>> call, Response<List<ShareVO>> response) {

                String date1;
                shareVOList = response.body();

                recycleAdapter = new Community_RecycleAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(recycleAdapter);
                Toast.makeText(getApplicationContext(), "로딩 완료!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<ShareVO>> call, Throwable t) {
                Log.d("TestActivity", t.toString());

            }
        });
    }
}
