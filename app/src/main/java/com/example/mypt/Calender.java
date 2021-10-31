package com.example.mypt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.datepicker.MaterialCalendar;
import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calender extends AppCompatActivity {

    MaterialCalendarView materialCalendarView;
    /** 여기부터 내비바 필요한거**/
    public Button btncomu,btncal,btnmy,btnstart;
    /** 여기까지 내비바 필요한거**/
    public ListView list_view ;
    String[] ptlist;
    public String[] routine ={};

    /**리사이클러*/
    TextView recycletext,recycletextday;
    List<CAL_Data> dataInfo;
    CAL_Data CAL_Data;
    RecyclerView recyclerView;
    CAL_RecycleAdapter recycleAdapter;
    List<CAL_Data> filterList;
    Gson gson;
    String searchday="2020-03-02";
    String Test1;
    String[] array;
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
        list_view = findViewById(R.id.list_view);


        filterList=new ArrayList<>();
        materialCalendarView = findViewById(R.id.calenderView);
        recycletextday = findViewById(R.id.recycletextday);
        recycletext = findViewById(R.id.recycletext);

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

                /**날짜 스트링변경*/
                materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
                    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);










                    @Override
                    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                        String selected_day, selected_moth, selected_year;
                        selected_day = String.valueOf(date.getDay());
                        selected_moth= String.valueOf(date.getMonth()+1);
                        selected_year= String.valueOf(date.getYear());
                        searchday=selected_year+"-"+selected_moth+"-"+selected_day;
//                LocalDate selected_date = LocalDate.parse(selected_date, inputFormatter);
//                String formattedDate = outputFormatter.format(selected_date);



                        /***날짜변경22/   /***/
                        filterList.clear();
                        recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body(),searchday);
                        recycleAdapter.notifyDataSetChanged();
                       // Log.d("TEST123 numi rotinedate" , response.body().get(72).getRoutineDate());
                        int numi = 0;
                        recycletext.setText("설정된 운동이 없습니다");
                        for (numi = 0;numi < 300;numi++){
                          //  Log.d("TEST!!!!",numi+"   "+response.body().get(numi).getRoutineDate());
                          //  Log.d("TEST!!! searchday",searchday);
                            recycletextday.setText(searchday);

                           // recycletext.setText("이날에 설정된 운동이 없습니다");
                            if (response.body().get(numi).getRoutineDate().equals(searchday)){
                                //filterList.add(response.body().get(numi));
                                //Log.d("TEST!!!! numi rotinedate" , response.body().get(numi).getRoutineDate());
                               // Log.d("TEST!!!! numi routinenmae" , response.body().get(numi).getWorkoutname());
                                //Log.d("TEST123 datechanged searchdate",searchday);

                                if(response.body().get(numi).getWorkoutname().equals(searchday))
                                {
                                    recycletext.setText("이날에 설정된 운동이 없습니다");
                                }
                                else{
                                    recycletext.setVisibility(View.VISIBLE);
                                    Test1=response.body().get(numi).getWorkoutname();

                                    Log.d("TEST!!!!!",Test1);
                                    array = Test1.split(",");
                                    String aaa ="";
                                    for(int i =0;i<array.length;i++){
                                        Log.d("TEST!!!!","length is " + i + array[i]);
                                        recycletext.setText(array[0]);
                                       aaa=aaa+array[i]+"\n";

                                    }
                                    //recycletext.setTextColor(getColor(black));
                                    recycletext.setText(aaa);

                                }


//                                    Log.d("TEST!!!!!",Test1);
//                                   array = Test1.split(",");
//                                    for(int i =0;i<array.length;i++){
//                                        Log.d("TEST!!!!","length is " + i + array[i]);
//                                    }
                               
                            }
                        }
                        //recycletext.setText(response.body().get(numi).getWorkoutname());


                        recycleAdapter.filterList(filterList);
                        /***날짜변경22/   /***/
                       // list_view.setAdapter(ArrayAdapter);
                        //ArrayAdapter.notifyDataSetChanged();

                    }





                });


                /***/

                /***날짜변경/   /***/
               // dataInfo = response.body();
                searchday="2021-05-05";
                Log.d("Test12 0505",searchday);
                recycleAdapter = new CAL_RecycleAdapter(getApplicationContext(),response.body(),searchday);

                for (int i=0;i < response.body().size();i++){
                  // Log.d("TEST123 for 들어가나" , "ㅂㅈㄷ1");
                    if (response.body().get(i).getRoutineDate().contains(searchday)){
                        //filterList.add(response.body().get(i));
                        Log.d("TEST12345", String.valueOf(i));

                    }
                }




                /***날짜변경/   /***/
                //recycleAdapter.filterList(filterList);






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
                //day.copyTo(calendar);
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
        //day.copyTo(calendar);
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
                //day.copyTo(calendar);
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
                //day.copyTo(calendar);
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
                //day.copyTo(calendar);
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
                //day.copyTo(calendar);
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
               //day.copyTo(calendar);
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
                Intent intent = new Intent (getApplicationContext(), Community_main.class);
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
                Intent intent = new Intent(getApplicationContext(),Watch.class);
                intent.putExtra("array",array);
                startActivity(intent);
            }
        });
        /** 여기까지 내비바 필요한거**/
        



    }
}