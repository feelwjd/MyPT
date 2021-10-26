package com.example.mypt;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class jgh_LoginRequest extends StringRequest {

    //서버 url 설정
    final static  private String URL="http://3.34.96.177:8000/users/signin";
    private Map<String,String>map;

    public jgh_LoginRequest(String userid, String pw, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("Userid",userid);
        map.put("Password",pw);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
