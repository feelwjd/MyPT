package com.example.mypt;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class jgh_RegisterRequest extends StringRequest {

    final static private String URL= "http://3.34.96.177:8000/users/signup";
    private Map<String,String>map;

    public jgh_RegisterRequest(String userid, String pw, String username, int height,int weight,int sex,Response.Listener<String>listener) {
        super(Method.POST, URL, listener, null);//위 url에 post방식으로 값을 전송

        map = new HashMap<>();
        map.put("Userid", userid);
        map.put("Password", pw);
        map.put("Username", username);
        map.put("Height", height + "");
        map.put("Weight", weight + "");
        map.put("Sex", sex + "");

    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}