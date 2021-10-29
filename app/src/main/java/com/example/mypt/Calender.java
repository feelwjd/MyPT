package com.example.mypt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.datepicker.MaterialCalendar;
import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calender extends AppCompatActivity  {

    MaterialCalendarView materialCalendarView;
    /** 여기부터 내비바 필요한거**/
    public Button btncomu,btncal,btnmy,btnstart;
    /** 여기까지 내비바 필요한거**/




    /**리사이클러*/
    List<CAL_Data> dataInfo;
    RecyclerView recyclerView;
    CAL_RecycleAdapter recycleAdapter;
    Gson gson;
    /**리사이클러*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

//        //타이틀바 없애는 코드
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
/***/
        dataInfo = new ArrayList<>();

        materialCalendarView = findViewById(R.id.calenderView);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);

            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                String selected_day, selected_moth, selected_year;
                selected_day = String.valueOf(date.getDay());
                selected_moth= String.valueOf(date.getMonth());
                selected_year= String.valueOf(date.getYear());
                String searchday;
                searchday=selected_year+"-"+selected_moth+"-"+selected_day;
//                LocalDate selected_date = LocalDate.parse(selected_date, inputFormatter);
//                String formattedDate = outputFormatter.format(selected_date);
                Log.d("TEST123",searchday);
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        JsonObject jsonObject = new JsonObject("feelwjd");
        CAL_RetrofitService retrofitService = CAL_APIClient.getClient().create(CAL_RetrofitService.class);
        Call<List<CAL_Data>> call = retrofitService.getData(jsonObject);
        call.enqueue(new Callback<List<CAL_Data>>() {
            @Override
            public void onResponse(Call<List<CAL_Data>> call, Response<List<CAL_Data>> response) {
//            String date1;
//                dataInfo = response.body();
//                date1 = String.valueOf(dataInfo.get(1).getRoutineDate());
//                Log.d("TEST1",date1);

                String date1;
                dataInfo = response.body();
                date1 = dataInfo.get(1).getRoutineDate();
                Log.d("Test12",date1);


                recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);


                recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body());
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<CAL_Data>> call, Throwable t) {

            }
        });


recyclerView.addItemDecoration(new CAL_RecyclerDecoration(1));

/***/

        //materialCalendarView.setSelectedDate(CalendarDay.today());






/** 토요일 파란색*/
        materialCalendarView.addDecorator(new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            public void SaturdayDecorator(){}
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.SATURDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLUE));

            }
        });
/** 일요일 빨간색*/
materialCalendarView.addDecorator((new DayViewDecorator() {
    private final Calendar calendar = Calendar.getInstance();
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay==Calendar.SUNDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.RED));

    }
}));




materialCalendarView.addDecorator(new MySelecotrDecorator(this) {});




//        String[] values = new String[] {"상체", "복부", "하체"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//        listView.setAdapter(adapter);






































/** 월요일 검정*/
        materialCalendarView.addDecorator((new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.MONDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLACK));

            }
        }));
/** 화요일 검정*/
        materialCalendarView.addDecorator((new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.TUESDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLACK));

            }
        }));
        /** 수요일 검정*/
        materialCalendarView.addDecorator((new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.WEDNESDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLACK));

            }
        }));
        /** 목요일 검정*/
        materialCalendarView.addDecorator((new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.THURSDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLACK));

            }
        }));
        /** 금요일 검정*/
        materialCalendarView.addDecorator((new DayViewDecorator() {
            private final Calendar calendar = Calendar.getInstance();
            @Override
            public boolean shouldDecorate(CalendarDay day) {
                day.copyTo(calendar);
                int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
                return weekDay==Calendar.FRIDAY;
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new ForegroundColorSpan(Color.BLACK));

            }
        }));
/**오늘 색상변환*/
        materialCalendarView.addDecorator(new DayViewDecorator() {

            private CalendarDay date;
            private MaterialCalendar date1;
            //private OnDateSelectedListener date1;

            @Override
            public boolean shouldDecorate(CalendarDay day) {
                date = CalendarDay.today();
                // materialCalendarView.setSelectedDate(CalendarDay.today());
                return day.equals(date);
            }

            @Override
            public void decorate(DayViewFacade view) {
                view.addSpan(new StyleSpan(Typeface.BOLD));
                view.addSpan(new RelativeSizeSpan(1.4f));
                view.addSpan(new ForegroundColorSpan(Color.rgb(153,204,255)));
            }
        });





        /** 여기부터 내비바 필요한거**/
        btncomu = findViewById(R.id.btncomu);
        btncal = findViewById(R.id.btncal);
        btnmy = findViewById(R.id.btnmy);
        btnstart = findViewById(R.id.btnstart);

        btncomu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
                startActivity(intent);
            }
        });

        btncal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent (getApplicationContext(), Calender.class);
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
                startActivity(intent);
            }
        });



        /** 여기까지 내비바 필요한거**/
        



    }
}