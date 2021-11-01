package com.example.mypt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class testpic extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);

        imageView = findViewById(R.id.imageView);

        Button button = findViewById(R.id.ydh1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendImageRequest();
            }
        });
    }

    public void sendImageRequest(){
        String url = "http://3.34.96.177:8000/images/KakaoTalk_20211012_195157072.png";
        ImageLoadTask task = new ImageLoadTask(url, imageView);
        task.execute();
    }

}
