package com.example.mypt;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CAL_RecyclerDecoration extends RecyclerView.ItemDecoration {

    private final int divHeight;


    public CAL_RecyclerDecoration(int divWidth) {
        this.divHeight = divWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = divHeight;
    }
}