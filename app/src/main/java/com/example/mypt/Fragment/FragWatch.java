package com.example.mypt.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mypt.R;

import java.util.concurrent.TimeUnit;

public class FragWatch extends Fragment{
    private View view;

    private String TAG = "프래그먼트";
    //
    private long timeCountInMilliSeconds = 1 * 60000;
    public String[] routine ={"상체","하체","기타등등"};
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

    //
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        view = inflater.inflate(R.layout.frag_watch, container, false);

        // 뷰 초기화
        initViews();
        // 리스너 초기화
       initListeners();
        return view;
    }

//뷰 초기화

    private void initViews() {
        progressBarCircle =  view.findViewById(R.id.progressBarCircle);
        editTextMinute = view.findViewById(R.id.editTextMinute);
        textViewTime = view.findViewById(R.id.textViewTime);
        imageViewReset = view.findViewById(R.id.imageViewReset);
        imageViewStartStop = view.findViewById(R.id.imageViewStartStop);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (view.getId()) {
                    case R.id.imageViewReset:
                        reset();
                        break;
                    case R.id.imageViewStartStop:
                        startStop();
                        break;
                }
            }
        };
    }

 //리스너 초기화
 private void initListeners() {
     View.OnClickListener listener = new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             switch (view.getId()) {
                 case R.id.imageViewReset:
                     reset();
                     break;
                 case R.id.imageViewStartStop:
                     startStop();
                     break;
             }
         }
     };

     imageViewReset.setOnClickListener(listener);
     imageViewStartStop.setOnClickListener(listener);
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

            time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {

            Toast.makeText(getContext(), "시간을 설정해주세요", Toast.LENGTH_LONG).show();
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
