package com.example.mypt;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private static int PICK_IMAGE_REQUEST = 1;

    ImageView image;
    Button btn_register;
    EditText userid, pw, username, height, weight, sex;
    RadioGroup sex_2;
    SignupVO signupVO = new SignupVO();
    String image2string;
    private String img_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //타이틀바 없애는 코드
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        ConstraintLayout constraintLayout = findViewById(R.id.container2);
//        userid = (EditText) findViewById(R.id.userid);
//        pw = (EditText) findViewById(R.id.pw);
//        username = (EditText) findViewById(R.id.username);
//        height = (EditText) findViewById(R.id.height);
//        weight = (EditText) findViewById(R.id.weight);
//        sex = (EditText) findViewById(R.id.sex);
//        sex_2 = (RadioGroup) findViewById(R.id.sex_2);
//        btn_register = (Button) findViewById(R.id.btn_register);
        image = (ImageView) findViewById(R.id.image);

//        sex_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            //해당하는 라디오박스의 항목들을 클릭하면 연령대 EditText에 해당 숫자들이 표시된다.
//            EditText sex = (EditText) findViewById(R.id.sex);

//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (i) {
//                    case R.id.sex_man:
//                        sex.setText("0");
//                        break;
//                    case R.id.sex_woman:
//                        sex.setText("1");
//                        break;
//                }
//            }
//        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = userid.getText().toString();
                String PW = pw.getText().toString();
                String NAME = username.getText().toString();
                String HEIGHT = height.getText().toString();
                String WEIGHT = weight.getText().toString();
                String SEX = sex.getText().toString();
                String IMAGE= img_path;

                Float height = Float.parseFloat(HEIGHT);
                Float weight = Float.parseFloat(WEIGHT);
                Integer sex = Integer.parseInt(SEX);

                ID = ID.trim();
                PW = PW.trim();
                NAME = NAME.trim();
                HEIGHT = HEIGHT.trim();
                WEIGHT = WEIGHT.trim();
                SEX = SEX.trim();
                //빈값이 넘어올때의 처리
                if (ID.getBytes().length <= 0 || PW.getBytes().length <= 0 || NAME.getBytes().length <= 0
                        || HEIGHT.getBytes().length <= 0 || WEIGHT.getBytes().length <= 0 || SEX.getBytes().length <= 0) {
                    Toast.makeText(SignUpActivity.this, "빈 값이 있습니다!", Toast.LENGTH_SHORT).show();
                }
                // 문제없으면, 회원가입을 진행합니다.
                else {
                    signup(new SignupObject(ID, PW, NAME, height, weight, sex, IMAGE));
                }
            }
        });
    }

    private void signup(SignupObject signupObject) {

        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))
        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<SignupVO> call = retrofitService.getSignup(signupObject);
        call.enqueue(new Callback<SignupVO>() {
            @Override
            public void onResponse(Call<SignupVO> call, Response<SignupVO> response) {
                signupVO = response.body();

                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "회원가입 성공했습니다!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SignupVO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "중복되는 아이디입니다!", Toast.LENGTH_SHORT).show();

                t.printStackTrace();
            }
        });
    }

    //로드버튼 클릭시 실행
    public void loadImagefromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); //ACTION_PIC과 차이점?
        intent.setType("image/*"); //이미지만 보이게
        //갤러리앱을 열어서 원하는 이미지를 선택
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //이미지 선택작업을 후의 결과 처리
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            //이미지를 골랐을때
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && null != data) {
                //data에서 절대경로로 이미지를 가져옴
                Uri uri = data.getData();

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                //이미지가 너무 크면 불러 오지 못하므로 사이즈를 줄여 준다.
                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                ImageView imgview = (ImageView) findViewById(R.id.image);
                imgview.setImageBitmap(scaled);


                if (uri != null) {
                    img_path = createCopyAndReturnRealPath(this, uri);
                }

            } else {
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
//    public String getPath(Uri uri) {
//        String[] projection = {MediaStore.Images.Media.DATA};
//        Cursor cursor = managedQuery(uri, projection, null, null, null);
//        startManagingCursor(cursor);
//        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        return cursor.getString(columnIndex);
//    }

    // 절대경로 파악할 때 사용된 메소드
    @Nullable
    public static String createCopyAndReturnRealPath(@NonNull Context context, @NonNull Uri uri) {
        final ContentResolver contentResolver = context.getContentResolver();

        if (contentResolver == null)
            return null;
        // 파일 경로를 만듬
        String filePath = context.getApplicationInfo().dataDir + File.separator
                + System.currentTimeMillis();
        File file = new File(filePath);
        try {
            // 매개변수로 받은 uri 를 통해  이미지에 필요한 데이터를 불러 들인다.

            InputStream inputStream = contentResolver.openInputStream(uri);
            if (inputStream == null)
                return null;
            // 이미지 데이터를 다시 내보내면서 file 객체에  만들었던 경로를 이용한다.
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0)
                outputStream.write(buf, 0, len);
            outputStream.close();
            inputStream.close();
        } catch (IOException ignore) {
            return null;
        }
        return file.getAbsolutePath();
    }
}