package com.example.mypt.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;


import com.example.mypt.R;

import java.util.List;

public class FragHome extends Fragment {
    private View view;


    public CalendarView calendarView;
    public TextView textView1;
    private ListView list; //리스트


    private String TAG = "프래그먼트";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_home, container, false);

        //로그인 및 회원가입 엑티비티에서 이름을 받아옴
        calendarView=view.findViewById(R.id.calendarView);
        textView1=view.findViewById(R.id.textView1);
        //Intent intent=getIntent();
        // String name=intent.getStringExtra("userName");
        // final String userID=intent.getStringExtra("userID");
        String name =  "박상현";
        String userID = "alexpark96";
        textView1.setText(name+" 운동일지");

        return view;
    }

}
