package com.example.mypt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Watch extends AppCompatActivity implements View.OnClickListener {

    private long timeCountInMilliSeconds = 1 * 60000;



    public String[] routine ={};
    public ListView list_view ;
    /** 여기부터 내비바 필요한거**/
    public Button btncomu,btncal,btnmy,btnstart;
    /** 여기까지 내비바 필요한거**/
    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;
    private ProgressBar progressBarCircle;
    private EditText editTextMinute;
    private TextView textViewTime;
    private ImageView imageViewReset;
    private ImageView imageViewStartStop;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        Intent intent = getIntent();
        String[] array = (String[]) intent.getSerializableExtra("array");
        Log.d("TEST!!!!!!", "!!!!!!!!!!!"+array);
        Log.d("TEST!!!!!", "SIZESIZE  "+ array.length);
        routine=array;

        // 뷰 초기화
        initViews();

        // 리스너 초기화
        initListeners();
        /** 여기부터 내비바 필요한거**/
        btncomu = findViewById(R.id.btncomu);
        btncal = findViewById(R.id.btncal);
        btnmy = findViewById(R.id.btnmy);
        btnstart = findViewById(R.id.btnstart);

        btncomu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Community_main.class);
                startActivity(intent);
            }
        });

        btncal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), CheckBody.class);
                startActivity(intent);
            }
        });

        btnmy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), CheckBody.class);
                startActivity(intent);
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Watch.class);

                Log.d("TEST!!!!!","WATCH array  "+ array);
                startActivity(intent);
            }
        });



        /** 여기까지 내비바 필요한거**/

    }


    /**
     *  뷰 초기화
     */
    private void initViews() {
        list_view = findViewById(R.id.list_view);
        progressBarCircle =  findViewById(R.id.progressBarCircle);
        editTextMinute = findViewById(R.id.editTextMinute);
        textViewTime = findViewById(R.id.textViewTime);
        imageViewReset = findViewById(R.id.imageViewReset);
        imageViewStartStop = findViewById(R.id.imageViewStartStop);
        List<String> list = new ArrayList<>();
        String[] ptlist = routine;



        ArrayAdapter<String>ArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_lay,ptlist){
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {

                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                tv.setTextColor(Color.rgb(0, 0 , 0));

                return view;

            }
        };

        list_view.setAdapter(ArrayAdapter);
    }

    /**
     * 리스너 초기화
     */
    private void initListeners() {
        imageViewReset.setOnClickListener(this);
        imageViewStartStop.setOnClickListener(this);
       // editTextMinute.setText(routine.length);
        textViewTime.setVisibility(View.INVISIBLE);

    }





    /**
     * 클릭 이벤트 설정
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewReset:
                reset();
                break;
            case R.id.imageViewStartStop:
                startStop();
                break;
        }
    }

    /**
     * 카운트 다운 시간을 리셋하고 재시작하는 기능
     */
    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();
    }

    /**
     * 타이머가 시작하고 멈추는 기능
     */
    private void startStop() {
        int routine_count = routine.length;

        if (timerStatus == TimerStatus.STOPPED) {

            setTimerValues();
            setProgressBarValues();

            imageViewReset.setVisibility(View.VISIBLE);
            imageViewStartStop.setImageResource(R.drawable.ic_baseline_stop_circle_24);
            editTextMinute.setEnabled(false);

            timerStatus = TimerStatus.STARTED;

            startCountDownTimer();

        } else {

            imageViewReset.setVisibility(View.GONE);
            imageViewStartStop.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
            editTextMinute.setEnabled(true);

            timerStatus = TimerStatus.STOPPED;

            stopCountDownTimer();

        }

    }

    /**
     * 타이머에 시간이 설정 되어있는지 체크하크
     *  - 있는 경우 : 타이머에 시간 세팅
     *  - 없는 경우 : 시간을 설정해달라는 안내 토스트 메세지
     */
    private void setTimerValues() {
        int time = 0;
        if (!editTextMinute.getText().toString().isEmpty()) {


            time = routine.length;
            //time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {

            Toast.makeText(getApplicationContext(), "시간을 설정해주세요", Toast.LENGTH_LONG).show();
        }

        timeCountInMilliSeconds = time * 30 * 1000;
    }

    /**
     * 카운트다운 시작 기능
     */
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTime.setVisibility(View.VISIBLE);
                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));

                setProgressBarValues();

                imageViewReset.setVisibility(View.GONE);

                imageViewStartStop.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);

                editTextMinute.setEnabled(true);

                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();
    }

    /**
     *  카운트 다운 정지 및 초기화
     */
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    /**
     * 원형 프로그레스 바에 값 세팅
     */
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }


    /**
     * 밀리언 초를 시간으로 포멧해주는 기능
     *
     * @param milliSeconds
     * @return HH:mm:ss 시간 포멧
     */
    private String hmsTimeFormatter(long milliSeconds) {

        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));


    }



}