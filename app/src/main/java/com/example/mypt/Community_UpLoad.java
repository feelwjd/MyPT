package com.example.mypt;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mypt.commu.ShareObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Community_UpLoad extends AppCompatActivity {
    private static int PICK_IMAGE_REQUEST = 1;
    ImageView image;
    private String img_path;
    Image img_path3;
    EditText commudescript, userid;
    Button btn_uploadthis;

    File file;
    //Bitmap image_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_upload);
        getSupportActionBar().setTitle("사진 업로드");

        ConstraintLayout constraintLayout = findViewById(R.id.container2);
        userid = (EditText) findViewById(R.id.userid2);
        commudescript = (EditText) findViewById(R.id.commudescript);
        btn_uploadthis = (Button) findViewById(R.id.btn_uploadthis);
        image = (ImageView) findViewById(R.id.image1);


        Button btn_community=(Button) findViewById(R.id.btn_community);
        btn_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), Community_main.class);
                startActivity(intent1);
            }
        });

        btn_uploadthis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = userid.getText().toString();
                String COMMUDESCRIPT = commudescript.getText().toString();
                String IMAGE= img_path;
                File file = new File(img_path);
                int UserRoutineId = 65;


                ID = ID.trim();
                COMMUDESCRIPT = COMMUDESCRIPT.trim();
                IMAGE = IMAGE.trim();

                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part image_file = MultipartBody.Part.createFormData("image", file.getName().concat(".jpg"), requestFile);
                RequestBody userid = RequestBody.create(MultipartBody.FORM,ID);
                RequestBody commudescript = RequestBody.create(MultipartBody.FORM,COMMUDESCRIPT);



                //빈값이 넘어올때의 처리
                if (ID.getBytes().length <= 0 || COMMUDESCRIPT.getBytes().length <= 0 || IMAGE.getBytes().length <= 0) {
                    Toast.makeText(Community_UpLoad.this, "빈 값이 있습니다!", Toast.LENGTH_SHORT).show();
                }
                // 문제없으면, 회원가입을 진행합니다.
                else {
                    upload(image_file, userid ,UserRoutineId ,commudescript);
                }

            }
        });
    }

    private void upload(MultipartBody.Part image, RequestBody userid, int userroutineid, RequestBody commudescript) {

        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))

        RetrofitService retrofitService = APIClient.getClient().create(RetrofitService.class);
        Call<ResponseBody> call = retrofitService.getShare(image,userid,userroutineid,commudescript);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //shareVO = response.body();

//                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(), "업로드 성공했습니다!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "업로드 실패했습니다!", Toast.LENGTH_SHORT).show();

                t.printStackTrace();
            }
        });
    }


    //로드버튼 클릭시 실행
    public void loadImagefromGallery2(View view) {
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

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                //image_send = bitmap;
                //이미지가 너무 크면 불러 오지 못하므로 사이즈를 줄여 준다.
//                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
//                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                ImageView img_view = (ImageView) findViewById(R.id.image1);
                img_view.setImageBitmap(bitmap);

                if (uri != null) {
                    img_path = createCopyAndReturnRealPath(this, uri);
//                    SaveBitmapToFileCache(bitmap, img_path);

                }

            } else {
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Oops! 로딩에 오류가 있습니다.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    public static void SaveBitmapToFileCache(Bitmap bitmap, String strFilePath, String filename) {



        File file = new File(strFilePath);



        if (!file.exists())

            file.mkdirs();



        File fileCacheItem = new File(strFilePath + filename);

        OutputStream out = null;



        try {

            fileCacheItem.createNewFile();

            out = new FileOutputStream(fileCacheItem);



            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

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
