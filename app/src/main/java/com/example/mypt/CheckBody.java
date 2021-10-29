package com.example.mypt;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class CheckBody extends AppCompatActivity {

    public Button btncomu,btncal,btnmy,btnstart;
    public Button mainbtn1,mainbtn2,mainbtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbody);



        mainbtn1 = findViewById(R.id.mainbtn1);

        mainbtn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BodyPicture.class);
                startActivity(intent);
            }
        });
        mainbtn2 = findViewById(R.id.mainbtn2);

        mainbtn2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),My_TestActivity.class);
                startActivity(intent);
            }
        });


        mainbtn4 = findViewById(R.id.mainbtn4);

        mainbtn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Community_main.class);
                startActivity(intent);
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
                Intent intent = new Intent (getApplicationContext(), CheckBody.class);
                startActivity(intent);
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Watch.class);
                startActivity(intent);
            }
        });



        /** 여기까지 내비바 필요한거**/
    }
}