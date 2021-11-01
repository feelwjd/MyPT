//package com.example.mypt;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class PopupActivity extends AppCompatActivity {
//
//
//    Button mbtn_url;
//    Button mbtn_url2;
//    Button mbtn_url3;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //타이틀바 없애기
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_popup);
//
//        mbtn_url = findViewById(R.id.btn_url);
//        mbtn_url.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View v){
//                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com"));
//                startActivity(urlintent);
//            }
//        });
//        mbtn_url2 = findViewById(R.id.btn_url2);
//        mbtn_url2.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View v){
//                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
//                startActivity(urlintent);
//            }
//        });
//        mbtn_url3 = findViewById(R.id.btn_url3);
//        mbtn_url3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View v){
//                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
//                startActivity(urlintent);
//            }
//        });
//
//    }
//
//    //확인 버튼 클릭
//    public void mOnClose(View v){
//        //데이터 전달하기
//        Intent intent = new Intent();
//        intent.putExtra("result", "Close Popup");
//        setResult(RESULT_OK, intent);
//
//        //액티비티(팝업) 닫기
//        finish();
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //바깥레이어 클릭시 안닫히게
//        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        //안드로이드 백버튼 막기
//        return;
//    }
//
//}
//
