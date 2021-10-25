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
import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import org.json.JSONArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;


import com.example.mypt.Config;
import com.example.mypt.R;
import com.example.mypt.TestActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


public class FragHome extends ListFragment {
    public TextView textView1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.frag_home, container, false);
        // xml의 listview id를 반드시 "@android:id/list"로 해줘야 한다.
        String[] values = new String[] {"상체", "복부", "하체"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        textView1=rootView.findViewById(R.id.textView1);
        String name = "박상현";
        String userID = "alexpark96";
        textView1.setText(name+"님의 MyPT");

        return rootView;
    }



    public void setDefaultJsonData(){
        try {
            //TODO JSONObject 객체 생성 및 데이터 삽입 실시
            JSONObject jsonob = new JSONObject();
            JSONArray jsonarr = new JSONArray();


            jsonob.put("userid","dbehdgns118");
            //jsonarr.add(jsonob);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }







    //아이템 클릭 이벤트
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String strText = (String) l.getItemAtPosition(position);
        Log.d("Fragment: ", position + ": " +strText);
        Toast.makeText(this.getContext(), "클릭: " + position +" " + strText, Toast.LENGTH_SHORT).show();
    }
}
