package com.example.mypt;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestActivity extends AppCompatActivity{
    private static final String TAG = "test";
    public static final int LOAD_SUCCESS = 101;


    private String REQUEST_URL = Config.APIROUTINEINFO; // 여기가 젤 중요한 부분인데 Config 파일의 모델을 사용함. 내용은 Config 파일 참고할것.

    private ProgressDialog progressDialog;
    private TextView textviewJSONText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button buttonRequestJSON = (Button)findViewById(R.id.button_main_requestjson);
        textviewJSONText = (TextView)findViewById(R.id.textview_main_jsontext);
        textviewJSONText.setMovementMethod(new ScrollingMovementMethod());

        buttonRequestJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog( TestActivity.this );
                progressDialog.setMessage("Please wait.....");
                progressDialog.show();

                getJSON(); // 아래의 getJSON() 호출 => 데이터 받아오는 부분
            }
        });
    }



    private final MyHandler mHandler = new MyHandler(this);


    private static class MyHandler extends Handler {
        private final WeakReference<TestActivity> weakReference;

        public MyHandler(TestActivity testActivity) {
            weakReference = new WeakReference<TestActivity>(testActivity);
        }

        @Override
        public void handleMessage(Message msg) {

            TestActivity testActivity = weakReference.get();

            if (testActivity != null) {
                switch (msg.what) {

                    case LOAD_SUCCESS:
                        testActivity.progressDialog.dismiss();

                        String jsonString = (String)msg.obj;

                        testActivity.textviewJSONText.setText(jsonString);
                        break;
                }
            }
        }
    }




    public void  getJSON() { //Json Parsing 하는 함수

        Thread thread = new Thread(new Runnable() {

            public void run() {

                String result;
                JSONObject body = new JSONObject(); //JSON 오브젝트의 head 부분
                try {

                    Log.d(TAG, REQUEST_URL);
                    URL url = new URL(REQUEST_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000); // 연결시간이 지정시간 넘어가면 타임아웃됨
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setRequestMethod("POST"); // GET 방식으로 가져오는데 이건 임시라서 POST형식으로 하는걸 추천
                    httpURLConnection.setRequestProperty("Content-Type","application/json");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();  // 연결


                    body.put("userid","dbehdgns118");
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
                    bufferedWriter.write(String.valueOf(body));
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    int responseStatusCode = httpURLConnection.getResponseCode();

                    InputStream inputStream;
                    if (responseStatusCode == HttpURLConnection.HTTP_OK) {

                        inputStream = httpURLConnection.getInputStream();
                    } else {
                        inputStream = httpURLConnection.getErrorStream();

                    }


                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    StringBuilder sb = new StringBuilder();
                    String line;


                    while ((line = bufferedReader.readLine()) != null) {





                        sb.append(line);
                    }

                    bufferedReader.close();
                    httpURLConnection.disconnect();

                    result = sb.toString().trim();


                } catch (Exception e) {
                    result = e.toString();

                   // String title = result.getString("RoutineDate");

                }


                Message message = mHandler.obtainMessage(LOAD_SUCCESS, result); // 받아온 Json 출력하는 부분인데 솔직히 이건 프론트 분들이 잘아실꺼라 생각함 ㅎㅎ;;;
                //나는 그냥 받아온거 그냥 쭉 보여준건데 이뿌게 잘 보이게 부탁해용^^7
                mHandler.sendMessage(message);
            }

        });
        thread.start();
    }
}
