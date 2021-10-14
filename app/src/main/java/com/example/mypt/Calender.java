package com.example.mypt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Calender extends AppCompatActivity {

    public CalendarView calendarView;
    public TextView textView1;
    private ListView list; //리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        calendarView=findViewById(R.id.calendarView);
        textView1=findViewById(R.id.textView1);

        list = (ListView)findViewById(R.id.list);//리스트뷰연결
        String data[] = {"등운동","하체","ㅁㄴㅇ"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);//어레이어댑터를 list에 세팅함
        adapter.notifyDataSetChanged(); //데이터를 저장하겠다라는 의미



        //로그인 및 회원가입 엑티비티에서 이름을 받아옴
        Intent intent=getIntent();
       // String name=intent.getStringExtra("userName");
       // final String userID=intent.getStringExtra("userID");
        String name =  "박상현";
        String userID = "alexpark96";
        textView1.setText(name+" 운동일지");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });



    }

//    <!-->



}
