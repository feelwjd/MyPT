package com.example.mypt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mypt.Fragment.FragFriend;
import com.example.mypt.Fragment.FragHome;
import com.example.mypt.Fragment.FragHotel;
import com.example.mypt.Fragment.FragStar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class Calender_Main extends AppCompatActivity {

     // 바텀 네비게이션
    BottomNavigationView bottomNavigationView;

    private String TAG = "메인";

    // 프래그먼트 변수
    Fragment fragment_home;
    Fragment fragment_star;
    Fragment fragment_group;
    Fragment fragment_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_main);


        // 프래그먼트 생성
        fragment_home = new FragHome();
        fragment_star = new FragStar();
        fragment_group = new FragFriend();
        fragment_hotel = new FragHotel();


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
                    case R.id.group:
                        Log.i(TAG, "group 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_group).commitAllowingStateLoss();
                        return true;
                    case R.id.hotel:
                        Log.i(TAG, "hotel 들어옴");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_hotel).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });




    }
}