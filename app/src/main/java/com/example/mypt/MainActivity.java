package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


        calenderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
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



    }
}