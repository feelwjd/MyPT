package com.example.mypt;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector extends Thread {

    @Override
    public void run(){
        try{

            URL url = new URL("http://3.34.96.177:8000");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

        }catch (Exception e){

        }
    }
}
