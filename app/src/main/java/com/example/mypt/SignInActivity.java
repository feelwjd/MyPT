package com.example.mypt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypt.users.SigndelObject;
import com.example.mypt.users.SigndelVO;
import com.example.mypt.users.SigninVO;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.mypt.users.SigninObject;

public class SignInActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tvTime;
    Dialog dialog;
    List<CAL_Data> dataInfo;
    TextInputEditText login_id, login_pw;
    Button btn_signin, btn_signup, btn_delete, no, check;
    EditText delete_id,delete_pw;
    //뒤로가기 버튼 눌렀던 시간 저장
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
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
        btn_delete=(Button) findViewById(R.id.btn_delete);

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

        dialog = new Dialog(SignInActivity.this);       // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog.setContentView(R.layout.activity_signdelete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdialog();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent1);
            }
        });


//-----------------------------------------------------------------------------------------------------------------------------------

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

        private void login(){
            String userid = login_id.getText().toString();
            String pw = login_pw.getText().toString();

            SigninObject signinObject = new SigninObject(userid, pw);
                //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
                RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
                Call<SigninVO> call = retrofitService.getLogin(signinObject);
                call.enqueue(new Callback<SigninVO>() {
                    @Override
                    public void onResponse(Call<SigninVO> call, Response<SigninVO> response) {
                        SigninVO signinVO = response.body();

                        if(signinVO != null){       // 회원입니다.
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), userid+"님 어서오세요!", Toast.LENGTH_SHORT).show();
                        }else{                      // 회원이 아닙니다.
                            Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SigninVO> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    //-----------------------------------------------------------------------------------------------------------------------------------
    public void showdialog() {
        dialog.show();

        delete_id = (EditText) dialog.findViewById(R.id.delete_id);
        delete_pw = (EditText) dialog.findViewById(R.id.delete_pw);
        no = (Button)dialog.findViewById(R.id.no);
        check = (Button)dialog.findViewById(R.id.check);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // 다이얼로그 닫기
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String del_userid = delete_id.getText().toString();
                String del_pw = delete_pw.getText().toString();
                del_userid=del_userid.trim();del_pw=del_pw.trim();

                if(del_userid.getBytes().length <= 0||del_pw.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(), "빈 값이 있습니다!", Toast.LENGTH_SHORT).show();
                }
                delete();
            }
        });
    }

    private void delete(){

        String del_userid = delete_id.getText().toString();
        String del_pw = delete_pw.getText().toString();

        SigndelObject signdelObject = new SigndelObject(del_userid, del_pw);
        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<SigndelVO> call = retrofitService.getSigndel(signdelObject);
        call.enqueue(new Callback<SigndelVO>() {
            @Override
            public void onResponse(Call<SigndelVO> call, Response<SigndelVO> response) {
                SigndelVO signdelVO = response.body();

                if(signdelVO != null){
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), del_userid+"님의 회원탈퇴가 완료돠었습니다!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SigndelVO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "회원탈퇴에 실패하였습니다!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //-----------------------------------------------------------------------------------------------------------------------------------
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