package com.example.mypt;

import androidx.appcompat.app.AppCompatActivity;
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

public class TestActivity extends AppCompatActivity{
    private static final String TAG = "test";
    public static final int LOAD_SUCCESS = 101;


    private String REQUEST_URL = Config.APIWORKOUT;

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

                getJSON();
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




    public void  getJSON() {

        Thread thread = new Thread(new Runnable() {

            public void run() {

                String result;

                try {

                    Log.d(TAG, REQUEST_URL);
                    URL url = new URL(REQUEST_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();


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
                }


                Message message = mHandler.obtainMessage(LOAD_SUCCESS, result);
                mHandler.sendMessage(message);
            }

        });
        thread.start();
    }
}
