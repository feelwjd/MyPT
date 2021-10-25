package com.example.mypt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.mypt.Fragment.FragWatch;
import com.example.mypt.Fragment.FragHome;
import com.example.mypt.Fragment.FragMypage;
import com.example.mypt.Fragment.FragStar;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Calender_Main extends AppCompatActivity {

     // 바텀 네비게이션
    BottomNavigationView bottomNavigationView;

    private String TAG = "메인";

    // 프래그먼트 변수
    Fragment fragment_home;
    Fragment fragment_star;
    Fragment fragment_watch;
    Fragment fragment_mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_main);


        // 프래그먼트 생성
        fragment_home = new FragHome();
        fragment_star = new FragStar();
        fragment_watch = new FragWatch();
        fragment_mypage = new FragMypage();


        // 바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 초기 플래그먼트 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commitAllowingStateLoss();


        // 바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        // 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "바텀 네비게이션 클릭");

                switch (item.getItemId()){
                    case R.id.home:
                        Log.i(TAG, "home 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_home).commitAllowingStateLoss();
                        return true;
                    case R.id.star:
                        Log.i(TAG, "star 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_star).commitAllowingStateLoss();
                        return true;
                    case R.id.watch:
                        Log.i(TAG, "watch 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_watch).commitAllowingStateLoss();
                        return true;
                    case R.id.mypage:
                        Log.i(TAG, "mypage 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_mypage).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });




    }
}