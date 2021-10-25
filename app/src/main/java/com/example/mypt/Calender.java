package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Calender extends AppCompatActivity {
    public TextView textView1;
    public ListView listView;
    /** 여기부터 내비바 필요한거**/
    public Button btncomu,btncal,btnmy;
    /** 여기까지 내비바 필요한거**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView1=findViewById(R.id.textView1);
        String name = "박상현";
        String userID = "alexpark96";
        textView1.setText(name+"님의 MyPT");

        listView=findViewById(R.id.list);
        String[] values = new String[] {"상체", "복부", "하체"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        /** 여기부터 내비바 필요한거**/
        btncomu = findViewById(R.id.btncomu);
        btncal = findViewById(R.id.btncal);
        btnmy = findViewById(R.id.btnmy);

        btncomu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
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
                Intent intent = new Intent (getApplicationContext(), Watch.class);
                startActivity(intent);
            }
        });
        /** 여기까지 내비바 필요한거**/
        



    }
}