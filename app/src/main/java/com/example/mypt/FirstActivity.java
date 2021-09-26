package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //2초뒤 Loginactivity로 전환되는 코드
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
    public void onBackPressed() {
        // 기존의 뒤로가기 버튼의 기능 제거
        // 2000밀리초 = 2초
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 앱 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }
    }
}