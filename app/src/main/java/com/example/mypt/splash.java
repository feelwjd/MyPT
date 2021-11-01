package com.example.mypt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class splash extends  AppCompatActivity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            ImageView load = (ImageView) findViewById(R.id.loading_view);
            Glide.with(this).load(R.raw.loading).into(load);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(splash.this, routinename.class);
                    startActivity(intent);
                }
            }, 3000);
}}
