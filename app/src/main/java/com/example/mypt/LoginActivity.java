package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tvTime;
    //뒤로가기 버튼 눌렀던 시간 저장
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //레이아웃, 텍스트뷰
        constraintLayout = findViewById(R.id.container);
        tvTime = findViewById(R.id.tv_time);
        //캘린더(시간)
        Calendar c = Calendar.getInstance();
        //시간 계산
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        //현재 시간에 따른 배경이미지 또는 환영인사 변경
        if (timeOfDay >= 6 && timeOfDay < 12) {
            //아침
            constraintLayout.setBackground(getDrawable(R.drawable.morning));
            tvTime.setText("좋은 아침입니다!");
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            //낮
            tvTime.setText("좋은 낮입니다!");
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            //저녁
            tvTime.setText("좋은 저녁입니다!");
        } else if(timeOfDay>=21&&timeOfDay<6){
            //밤
            constraintLayout.setBackground(getDrawable(R.drawable.night));
            tvTime.setText("좋은 밤입니다!");
        }
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