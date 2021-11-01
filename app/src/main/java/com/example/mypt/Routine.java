package com.example.mypt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Routine extends AppCompatActivity implements View.OnClickListener {
//    public Button btncomu,btncal,btnmy,btnstart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        findViewById(R.id.btn2).setOnClickListener(this);

//        btncomu = findViewById(R.id.btncomu);
//        btncal = findViewById(R.id.btncal);
//        btnmy = findViewById(R.id.btnmy);
//        btnstart = findViewById(R.id.btnstart);
//
//        btncomu.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent (getApplicationContext(), Community_main.class);
//                startActivity(intent);
//            }
//        });
//
//        btncal.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent (getApplicationContext(), Calender.class);
//                startActivity(intent);
//            }
//        });
//
//        btnmy.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent (getApplicationContext(), CheckBody.class);
//                startActivity(intent);
//            }
//        });
//
//        btnstart.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(),Watch.class);
//                startActivity(intent);
//            }
//        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn2:
                new AlertDialog.Builder(this)
                        .setTitle("테스트 팝업")
                        .setMessage("팝업 창 내용 테스트중")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dlg, int sumthin){

                            }
                        })
                        .show();
                    break;

            default:
        }
    }

}