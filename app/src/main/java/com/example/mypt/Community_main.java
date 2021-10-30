package com.example.mypt;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypt.commu.CommunityObject;
import com.example.mypt.commu.CommunityVO;
import com.example.mypt.users.SignupObject;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Community_main extends AppCompatActivity{
    Button btn_upload, btn_mainmenu;
    List<CommunityVO> dataInfo;
    RecyclerView recyclerView;
    Community_RecycleAdapter recycleAdapter;
    Gson gson;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_main);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ConstraintLayout constraintLayout = findViewById(R.id.container2);

        dataInfo = new ArrayList<>();
        recyclerView = findViewById(R.id.community_recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CommunityObject communityObject = new CommunityObject("feelwjd");
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<List<CommunityVO>> call = retrofitService.getCommunity(communityObject);
        call.enqueue(new Callback<List<CommunityVO>>() {
        @Override
            public void onResponse(Call<List<CommunityVO>> call, Response<List<CommunityVO>> response) {
                Log.d("Test","sex");
                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;
                recycleAdapter = new Community_RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<CommunityVO>> call, Throwable t) {
                Log.d("Community_mainActivity",t.toString());
            }
        });

        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_mainmenu=(Button) findViewById(R.id.btn_mainmenu);

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), Community_UpLoad.class);
                startActivity(intent1);
            }
        });

        btn_mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
