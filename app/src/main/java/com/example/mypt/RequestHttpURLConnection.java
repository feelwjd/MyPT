package com.example.mypt;
import android.content.ContentValues;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class RequestHttpURLConnection {
    public ArrayList<RoutineInfoVO> request(String _url, JSONObject _params){

        // HttpURLConnection 참조 변수.
        //HttpURLConnection urlConn = null;
        // URL 뒤에 붙여서 보낼 파라미터.
        //StringBuffer sbParams = new StringBuffer();

        /**
         * 1. StringBuffer에 파라미터 연결
         * */
        // 보낼 데이터가 없으면 파라미터를 비운다.

        /**
         * 2. HttpURLConnection을 통해 web의 데이터를 가져온다.
         * */
        ArrayList<RoutineInfoVO> list_routineinfo = new ArrayList<>();
        Gson gson = new Gson();
        //String result;
        JSONObject body = new JSONObject(); //JSON 오브젝트의 head 부분
        try {


            URL url = new URL(_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(3000); // 연결시간이 지정시간 넘어가면 타임아웃됨
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST"); // GET 방식으로 가져오는데 이건 임시라서 POST형식으로 하는걸 추천
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();  // 연결


            body.put("userid","dbehdgns118");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
            bufferedWriter.write(String.valueOf(_params));

            bufferedWriter.flush();
            bufferedWriter.close();

            int responseStatusCode = httpURLConnection.getResponseCode();

            InputStream inputStream;
            if (responseStatusCode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();

            }
            byte[] aaa = new byte[inputStream.available()];
            inputStream.read(aaa);
            inputStream.close();
            String json = new String(aaa,"UTF-8");

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("ROUTINEINFO");

            int index = 0;

            while (index < jsonArray.length()) {

                RoutineInfoVO routineInfoVO = gson.fromJson(jsonArray.get(index).toString(), RoutineInfoVO.class);
                list_routineinfo.add(routineInfoVO);
                index++;
            }

            //InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
           // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //StringBuilder sb = new StringBuilder();
            //String line;


            //while ((line = bufferedReader.readLine()) != null) {
            //    sb.append(line);
            //}

           // bufferedReader.close();
            httpURLConnection.disconnect();

            //result = sb.toString().trim();
            return list_routineinfo;


        } catch (Exception e) {
            //result = e.toString();
        }


    return null;
    }



}


