package com.example.mypt;



import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class DbTest extends AppCompatActivity {
    String line = "";
    StringBuffer buffer = new StringBuffer();
    private TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbtest);

        tvData = (TextView)findViewById(R.id.textView);
        Button btn = (Button)findViewById(R.id.httpTest);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONTask().execute("http://3.34.96.177:8000/api/user-routine");
            }
        });



    }


    public class JSONTask extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... urls) {
            try {
                //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("userid", "dbehdgns118");
                //jsonObject.accumulate("name", "yun");





                HttpURLConnection con = null;
                BufferedReader reader = null;

                try{
                    //URL url = new URL("http://192.168.25.16:3000/users");
                    URL url = new URL(urls[0]);
                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Cache-Control", "no-cache");
                    con.setRequestProperty("Content-Type", "application/json");
                    con.setRequestProperty("Accept", "text/html");
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.connect();

                    OutputStream outStream = con.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
                    writer.write(jsonObject.toString());
                    writer.flush();
                    writer.close();

                    InputStream stream = con.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    //StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while((line = reader.readLine()) != null){

                        //Log.d("test",line);
                        buffer.append(line);
                    }


                    //Log.d("test", buffer.getClass().getName());
                    return buffer.toString();

                } catch (MalformedURLException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(con != null){
                        con.disconnect();
                    }
                    try {
                        if(reader != null){
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
        int j = 0;
        int i =0;
        public HashMap<String, String> convertToHashMap(String jsonString) {
            HashMap<String, String> myHashMap = new HashMap<String, String>();
            try {
                JSONArray jArray = new JSONArray(jsonString);
                JSONObject jObject = null;
                String keyString=null;

                Log.d("test", "jsonString "+jArray);
                Log.d("test", "jsonString.length() "+jsonString.length());
                Log.d("test", "buffer "+buffer);
                Log.d("test", "buffer.length() "+buffer.length());
//                for (int i = 0; i < buffer.length(); i++) {
//                    jObject = jArray.getJSONObject(i);
//                    // beacuse you have only one key-value pair in each object so I have used index 0
//                    //keyString = (String)jObject.names().get(3);
//                    j=i;
//                   // myHashMap.put(keyString, jObject.getString(keyString));
//                }
                j=3;
                do{
                    if(i<(buffer.length()-4)) {
                        jObject = jArray.getJSONObject(i);
//                    // beacuse you have only one key-value pair in each object so I have used index 0
                        keyString = (String) jObject.names().get(j);
                        j += 3;
                        myHashMap.put(keyString, jObject.getString(keyString));
                        i++;
                    }
                    else break;
                }while(i<buffer.length());


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return myHashMap;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            tvData.setText(result);

            HashMap<String, String> map = convertToHashMap(buffer.toString());
            Log.d("test", "j "+ j);
            // Log.d("test", "test"+map);
            // Log.d("test", "test type "+map.getClass().getName());
            // Log.d("test", "test datas "+buffer);
        }

    }

}

