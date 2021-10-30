package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mypt.users.SigninVO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button calenderBtn = (Button) findViewById(R.id.btn1);
        Button watchbtn = (Button) findViewById(R.id.btn2);
        Button ttbtn = (Button) findViewById(R.id.btn3);
        Button calbtn = (Button) findViewById(R.id.btn4);
        Button logoutbtn = (Button) findViewById(R.id.btn5);

        Intent intent = getIntent();
        SigninVO signinVO = intent.getParcelableExtra("signinVO");


        calenderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });
        watchbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Watch.class);
                startActivity(intent);
            }
        });
        ttbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), DbTest.class);
                startActivity(intent);
            }
        });

        calbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });

        //로그아웃
        logoutbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this/*현재 액티비티 위치*/ , SignInActivity.class/*이동 액티비티 위치*/);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "로그아웃 완료!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}