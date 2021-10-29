package com.example.mypt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mypt.R;


public class My_beforeafter extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybeforeafter);

        imageView = findViewById(R.id.imageView22);

        Button button = findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendImageRequest();
            }
        });
    }

    public void sendImageRequest(){
        String url = "https://movie-phinf.pstatic.net/20161123_188/1479862185516tYkKO_JPEG/movie_image.jpg";
        ImageLoadTask task = new ImageLoadTask(url, imageView);
        task.execute();
    }

}
