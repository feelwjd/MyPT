package com.example.mypt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Routine extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        findViewById(R.id.btn2).setOnClickListener(this);
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