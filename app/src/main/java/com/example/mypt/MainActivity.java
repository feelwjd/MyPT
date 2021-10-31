package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypt.My_beforeafter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button calenderBtn = (Button) findViewById(R.id.btn1);
        Button watchbtn = (Button) findViewById(R.id.btn2);
        Button ttbtn = (Button) findViewById(R.id.btn3);
        Button calbtn = (Button) findViewById(R.id.btn4);
        Button logoutbtn = (Button) findViewById(R.id.btn5);

       // CallRetrofit();

        calenderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });
        watchbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Watch.class);
                startActivity(intent);
            }
        });
        ttbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), My_beforeafter.class);
                startActivity(intent);
            }
        });

        //////////////////////////////////////////////




//        ttbtn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent (getApplicationContext(), DbTest.class);
//                startActivity(intent);
//            }
//        });






        //////////////////////////////////////////////

        calbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });




        calbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        //로그아웃
        logoutbtn.setOnClickListener(new View.OnClickListener(){
=======
        /**
        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.34.96.177:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);
        Call<Datamodel> call = myAPICall.getData();
        //대기열이라는데
        call.enqueue(new Callback<Datamodel>() {
            @Override
            public void onResponse(Call<Datamodel> call, Response<Datamodel> response) {
                //리스폰스 체크
       if(response.code()!=200){
           txt.setText("커넥션 오류 ");
            return;
                                }

       //데이터를 텍스트뷰로 받아들인다다
                String jsony ="";
       jsony = "userID= "+ response.body().getUserid() +
               "\nRoutineDate= "+ response.body().getRoutineDate();
            //txt.append(jsony);

           }

            @Override
            public void onFailure(Call<Datamodel> call, Throwable t) {

            }
        });
**/
        //Retrofit Post Builder

>>>>>>> 72abd22a2f70707e37cd1e229f46945aa10bd94b

            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this/*현재 액티비티 위치*/ , SignInActivity.class/*이동 액티비티 위치*/);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "로그아웃 완료!", Toast.LENGTH_SHORT).show();
            }
        });
    }
<<<<<<< HEAD

=======
//    void CallRetrofit() {
//        String postBody= "dbehdgns118";  /**txt.getText().toString();**/ //이부분에 포스트 넣을거인거같은데??
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://3.34.96.177:8000/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        PostReqeustApi postReqeustApi = retrofit.create(PostReqeustApi.class);
//
//        //Mock data test
//        PostModel postModel = new PostModel("post1", postBody);
//
//        Call<PostModel> call= postReqeustApi.PostDataIntoServer(postModel);
//
//        call.enqueue(new Callback<PostModel>() {
//            @Override
//            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
//                //보여준다 결과를
//                txt.setText(response.body().bodypost);
//            }
//
//            @Override
//            public void onFailure(Call<PostModel> call, Throwable t) {
//
//            }
//        });
//
//    }
>>>>>>> 72abd22a2f70707e37cd1e229f46945aa10bd94b
}