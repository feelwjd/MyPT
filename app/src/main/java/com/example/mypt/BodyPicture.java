package com.example.mypt;

import android.annotation.SuppressLint;
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
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
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

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    ImageView image;
    File file;
    Image image_path3;
    Button savepic;
    private String img_path;
    //

//
    beforeafterVO beforeafterVO = new beforeafterVO();
    private com.example.mypt.mypage.beforeafterObject beforeafterObject;
//
//    @SuppressLint("WrongThread")
//    @Override
    @SuppressLint("WrongThread")
    protected void onCreate(Bundle savedInstanceState) {
//        savepic = findViewById(R.id.savepic);
//        savepic.setEnabled(false);
//        savepic.setOnClickListener(new View.OnClickListener()

//        FileUploadUtils.send2Server(tempSelectFile);

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
                intent.setType("image/*");  //??????
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);

                //////////////////////////////////
//                String ID = userid.getText().toString();
//                String COMMUDESCRIPT = commudescript.getText().toString();
//                String IMAGE= img_path;
//                File file = new File(img_path);
//                int UserRoutineId = 65;
//                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//                MultipartBody.Part image_file = MultipartBody.Part.createFormData("image", file.getName().concat(".jpg"), requestFile);
//                RequestBody userid = RequestBody.create(MultipartBody.FORM,ID);
//                RequestBody commudescript = RequestBody.create(MultipartBody.FORM,COMMUDESCRIPT);
//
//                ID = ID.trim();
//                COMMUDESCRIPT = COMMUDESCRIPT.trim();
//                IMAGE = IMAGE.trim();
//
//                //????????? ??????????????? ??????
//                if (ID.getBytes().length <= 0 || COMMUDESCRIPT.getBytes().length <= 0 || IMAGE.getBytes().length <= 0) {
//                    Toast.makeText(Community_UpLoad.this, "??? ?????? ????????????!", Toast.LENGTH_SHORT).show();
//                }
//                // ???????????????, ??????????????? ???????????????.
//                else {
//                    savepic(image_file, userid ,UserRoutineId ,commudescript);
//                }
//
//            }
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
//                        Toast.makeText(getApplicationContext(), "??????????????? ?????????????????????.", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<beforeafterVO> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "?????? ??????!", Toast.LENGTH_SHORT).show();
//
//                        t.printStackTrace();
//                    }
//                });


                savepic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "??????????????? ?????????????????????.", Toast.LENGTH_SHORT).show();

                        //List<POST> postList = Arrays.asList(gson.fromJson(reader,))

//                    }

//                }
//                );
                    }
                });
            }
        });

//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data){
//            if (requestCode != 1 || resultCode != RESULT_OK) {
//                return;
//            }
//            Uri dataUri = data.getData();
//            imgVwSelected.setImageURI(dataUri)
//            try {
//                // ImageView ??? ????????? ??????
//                InputStream in = getContentResolver().openInputStream(dataUri);
//                Bitmap image = BitmapFactory.decodeStream(in);
//                imgVwSelected.setImageBitmap(image);
//                in.close();
//
//                // ????????? ????????? ?????? ???
//
//                String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
//                tempSelectFile = new File(Environment.getExternalStorageDirectory()+"/Pictures/Test/", "temp_" + date + ".jpeg");
//                OutputStream out = new FileOutputStream(tempSelectFile);
//                image.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            }
//            catch(IOException ioe) {
//                ioe.printStackTrace();
//            }
//            savepic.setEnabled(true);
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
        intent.setType("image/*"); //???????????? ?????????
     //   intent.setType("album/*"); //???????????? ??????
        //??????????????? ????????? ????????? ???????????? ??????
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    private void afterpic(beforeafterObject beforeafterObject) {
        My_RetrofitService retrofitService = APIClient.getClient().create(My_RetrofitService.class);
        Call<beforeafterVO> call = retrofitService.getbeforeafter(beforeafterObject);
        call.enqueue(new Callback<beforeafterVO>() {
            @Override
            public void onResponse(Call<beforeafterVO> call, Response<beforeafterVO> response) {
                beforeafterVO = response.body();

                Toast.makeText(getApplicationContext(), "??????????????? ?????????????????????.", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<beforeafterVO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "?????? ??????!", Toast.LENGTH_SHORT).show();

                t.printStackTrace();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            //???????????? ????????????
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && null != data) {
                //data?????? ??????????????? ???????????? ?????????
                Uri uri = data.getData();

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                //???????????? ?????? ?????? ?????? ?????? ???????????? ???????????? ?????? ??????.
                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                ImageView imgview = (ImageView) findViewById(R.id.album);
                imgview.setImageBitmap(scaled);

                if (uri != null) {
                    img_path = createCopyAndReturnRealPath(this, uri);
                    //Toast.makeText(this, img_path, Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "?????? ???????????????.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "????????? ??????????????????.", Toast.LENGTH_LONG).show();
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

    // ???????????? ????????? ??? ????????? ?????????
    @Nullable
    public static String createCopyAndReturnRealPath(@NonNull Context context, @NonNull Uri uri) {
        final ContentResolver contentResolver = context.getContentResolver();

        if (contentResolver == null)
            return null;
        // ?????? ????????? ??????
        String filePath = context.getApplicationInfo().dataDir + File.separator
                + System.currentTimeMillis();
        File file = new File(filePath);
        try {
            // ??????????????? ?????? uri ??? ??????  ???????????? ????????? ???????????? ?????? ?????????.

            InputStream inputStream = contentResolver.openInputStream(uri);
            if (inputStream == null)
                return null;
            // ????????? ???????????? ?????? ??????????????? file ?????????  ???????????? ????????? ????????????.
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
            Toast toast = Toast.makeText(BodyPicture.this, "????????? ?????????", Toast.LENGTH_SHORT );
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
            Toast toast = Toast.makeText(BodyPicture.this, "?????? ?????????", Toast.LENGTH_SHORT );
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