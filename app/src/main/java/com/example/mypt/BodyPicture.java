package com.example.mypt;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;
import java.util.HashMap;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mypt.mypage.beforeafterObject;
import com.example.mypt.mypage.beforeafterVO;
import com.example.mypt.users.SignupObject;
import com.example.mypt.users.SignupVO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyPicture extends AppCompatActivity {

//    public Button btncomu,btncal,btnmy,btnstart;
    private int CURRENT_INDEX;
    private ImageView[] imageViews;

    //
    private static final int REQUEST_CODE = 0;
    private static int PICK_IMAGE_REQUEST = 1;
    ImageView imageView;
    ImageView image0;
    //
    ImageView album;
    Button savepic;
    private String img_path;
    //



//    btnImageSend = findViewById(R.id.btnImageSend);
//    btnImageSend.setEnabled(false);
//    btnImageSend.setOnClickListener(new View.OnClickListener()





    beforeafterVO beforeafterVO = new beforeafterVO();
    private com.example.mypt.mypage.beforeafterObject beforeafterObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodypicture);
        init();
        savepic = (Button) findViewById(R.id.savepic);
        imageView = findViewById(R.id.imageView);

                sendImageRequest();


        album = (ImageView) findViewById(R.id.album);

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
               // intent.setType("album/*");
                intent.setType("image/*");  //추가
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);

                //////////////////////////////////
//
//                String IMAGE= img_path;
//                //IMAGE = IMAGE.trim();
//                afterpic(new beforeafterObject(IMAGE));
//                My_RetrofitService retrofitService = APIClient.getClient().create(My_RetrofitService.class);
//                Call<beforeafterVO> call = retrofitService.getbeforeafter(beforeafterObject);
//                call.enqueue(new Callback<beforeafterVO>() {
//                    @Override
//                    public void onResponse(Call<beforeafterVO> call, Response<beforeafterVO> response) {
//                        beforeafterVO = response.body();
//
//                        Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<beforeafterVO> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "저장 실패!", Toast.LENGTH_SHORT).show();
//
//                        t.printStackTrace();
//                    }
//                });


                savepic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();

                        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))

//                    }

//                }
//                );
                    }
                });
            }
        });

//        imgVwSelected = findViewById(R.id.imgVwSelected);
//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data){
//            if (requestCode != 1 || resultCode != RESULT_OK) {
//                return;
//            }
//            Uri dataUri = data.getData();
//            imgVwSelected.setImageURI(dataUri);
//            try {
//                // ImageView 에 이미지 출력
//                InputStream in = getContentResolver().openInputStream(dataUri);
//                Bitmap image = BitmapFactory.decodeStream(in);
//                imgVwSelected.setImageBitmap(image);
//                in.close();
//
//                // 선택한 이미지 임시 저
//
//                String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
//                tempSelectFile = new File(Environment.getExternalStorageDirectory()+"/Pictures/Test/", "temp_" + date + ".jpeg");
//                OutputStream out = new FileOutputStream(tempSelectFile);
//                image.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            }
//            catch(IOException ioe) {
//                ioe.printStackTrace();
//            }
//            btnImageSend.setEnabled(true);
//        }




    }
    /////////////////////////////////////////////////////////////////////////////
    public void sendImageRequest(){
        String url = "http://3.34.96.177:8000/images/KakaoTalk_20211012_195157072.png";
        ImageLoadTask task = new ImageLoadTask(url, imageView);
        task.execute();
    }
    /////////////////////////////////////////////////////////////////////////////

    public void loadImagefromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); //이미지만 보이게
     //   intent.setType("album/*"); //이미지만 호출
        //갤러리앱을 열어서 원하는 이미지를 선택
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    private void afterpic(beforeafterObject beforeafterObject) {
        My_RetrofitService retrofitService = APIClient.getClient().create(My_RetrofitService.class);
        Call<beforeafterVO> call = retrofitService.getbeforeafter(beforeafterObject);
        call.enqueue(new Callback<beforeafterVO>() {
            @Override
            public void onResponse(Call<beforeafterVO> call, Response<beforeafterVO> response) {
                beforeafterVO = response.body();

                Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<beforeafterVO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "저장 실패!", Toast.LENGTH_SHORT).show();

                t.printStackTrace();
            }
        });

    }

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

                ImageView imgview = (ImageView) findViewById(R.id.album);
                imgview.setImageBitmap(scaled);

                if (uri != null) {
                    img_path = createCopyAndReturnRealPath(this, uri);
                    //Toast.makeText(this, img_path, Toast.LENGTH_LONG).show();
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

    private void init(){

        ImageView imageView0 = (ImageView)findViewById(R.id.imageView) ;
        ImageView imageView1 = (ImageView)findViewById(R.id.album);

        imageViews = new ImageView[]{ imageView0, imageView1 };
        imageView0.setVisibility(View.VISIBLE);
        CURRENT_INDEX = 0;
    }

    public void onClickNext(View view){

        if( ++CURRENT_INDEX > 1) {
            Toast toast = Toast.makeText(BodyPicture.this, "마지막 이미지", Toast.LENGTH_SHORT );
            toast.show();

            CURRENT_INDEX--;
        }
        else{
            for( int i = 0; i < imageViews.length; i++){
                if( i == CURRENT_INDEX){
                    imageViews[i].setVisibility(View.VISIBLE);
                }
                else{
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public void onClickPrev(View view){



        if( --CURRENT_INDEX < 0) {
            Toast toast = Toast.makeText(BodyPicture.this, "처음 이미지", Toast.LENGTH_SHORT );
            toast.show();

            CURRENT_INDEX++;
        }
        else{
            for( int i = 0; i < imageViews.length; i++){
                if( i == CURRENT_INDEX){
                    imageViews[i].setVisibility(View.VISIBLE);
                }
                else{
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        }

    }









}