package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbody);

        Button imageButton = (Button) findViewById(R.id.btn1);
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BodyPicture.class);
                startActivity(intent);
            }
        });

        imageButton = (Button) findViewById(R.id.btn2);
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
            Intent intent = new Intent(getApplicationContext(), Routine.class);
            startActivity(intent);
            }
    }
        );

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }
}