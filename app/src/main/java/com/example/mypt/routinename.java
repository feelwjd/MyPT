package com.example.mypt;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class routinename extends AppCompatActivity {

    int[] images = new int[] {
//            R.drawable.routine1,
            R.drawable.routine2,
            R.drawable.routine3,
            R.drawable.routine4,
            R.drawable.routine5,
            R.drawable.routine6,
            R.drawable.routine7,
            R.drawable.routine8,
            R.drawable.routine9,
            R.drawable.routine10


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        ImageView mImageView = (ImageView)findViewById(R.id.ydhimg);

        int imageId = (int)(Math.random() * images.length);

        mImageView.setBackgroundResource(images[imageId]);




}}
