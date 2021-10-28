package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login_Activity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tvTime;

    List<CAL_Data> dataInfo;
    TextInputEditText login_id, login_pw;
    Button btn_signin, btn_signup;

    //뒤로가기 버튼 눌렀던 시간 저장
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //레이아웃, 텍스트뷰
        constraintLayout = findViewById(R.id.container1);
        tvTime = findViewById(R.id.tv_time);
        login_id= (TextInputEditText) findViewById(R.id.login_id);
        login_pw = (TextInputEditText)findViewById(R.id.login_pw);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signup=(Button) findViewById(R.id.btn_signup);
        //캘린더(시간)
        Calendar c = Calendar.getInstance();
        //시간 계산
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        //현재 시간에 따른 배경이미지 또는 환영인사 변경
        if (timeOfDay >= 6 && timeOfDay < 12) {
            //아침
            constraintLayout.setBackground(getDrawable(R.drawable.morning));
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            //낮
            constraintLayout.setBackground(getDrawable(R.drawable.afternoon));
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            //저녁
            constraintLayout.setBackground(getDrawable(R.drawable.midnight));
        } else if(timeOfDay>=21&&timeOfDay<6){
            //밤
            constraintLayout.setBackground(getDrawable(R.drawable.night));

        }

        Button btn_signup=(Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent1);
            }
        });
        //------------------------------------------------------------------------

        JsonObject jsonObject = new JsonObject(login_id,login_pw);
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        Login_RetrofitService retrofitService = Retrofit.getClient().create(Login_RetrofitService.class);
        Call<List<CAL_Data>> call = retrofitService.getData(jsonObject);
        call.enqueue(new Callback<List<CAL_Data>>() {
            @Override
            public void onResponse(Call<List<CAL_Data>> call, Response<List<CAL_Data>> response) {
                Log.d("Test","sex");
                //dataList = response.body();
                //Log.d("TestActivity",dataList.toString());
                //dataList = response.body().toString();
                //dataInfo = dataList.body;

            }

            @Override
            public void onFailure(Call<List<CAL_Data>> call, Throwable t) {
                Log.d("TestActivity",t.toString());
            }
        });
        //------------------------------------------------------------------------
    }

    public void onBackPressed() {
        //2000밀리초 = 2초
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        //2초 이내에 뒤로가기 버튼을 한번 더 클릭시 앱 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }
    }
}