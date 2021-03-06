package com.example.mypt;

import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.ShareVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Community_main extends AppCompatActivity{
    Button btn_upload, btn_mainmenu, btn_f5;
    List<ShareVO> shareVOList;
    RecyclerView recyclerView;
    Commu_RecycleAdapter commuRecycleAdapter;
    String[] array;
    Gson gson;

    /** 여기부터 내비바 필요한거**/
    public Button btncomu,btncal,btnmy,btnstart;
    /** 여기까지 내비바 필요한거**/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_main);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ConstraintLayout constraintLayout = findViewById(R.id.container2);

        shareVOList = new ArrayList<>();
        recyclerView = findViewById(R.id.community_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Community_UpLoad.class);
                startActivity(intent);
            }
        });

        btn_mainmenu=(Button) findViewById(R.id.btn_mainmenu);
        btn_mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), Calender.class);
                startActivity(intent1);
            }
        });

        btn_f5=(Button) findViewById(R.id.btn_f5);
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

        btncomu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Community_main.class);
                startActivity(intent);
            }
        });

        btncal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });

        btnmy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), CheckBody.class);
                startActivity(intent);
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Watch.class);
                intent.putExtra("array",array);
                startActivity(intent);
            }
        });
        /** 여기까지 내비바 필요한거**/
    }

    private void f5(){

        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<ShareVO>> call = retrofitService.getCommu();
        call.enqueue(new Callback<List<ShareVO>>() {
            @Override
            public void onResponse(Call<List<ShareVO>> call, Response<List<ShareVO>> response) {


                String date1;
                shareVOList = response.body();


                commuRecycleAdapter = new Commu_RecycleAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(commuRecycleAdapter);
            }

            @Override
            public void onFailure(Call<List<ShareVO>> call, Throwable t) {
                Log.d("TestActivity", t.toString());
            }
        });
    }

}
