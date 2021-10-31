//package com.example.mypt;
//
//import android.graphics.Color;
//import android.graphics.Typeface;
//import android.text.style.ForegroundColorSpan;
//import android.text.style.RelativeSizeSpan;
//import android.text.style.StyleSpan;
//
//import com.prolificinteractive.materialcalendarview.CalendarDay;
//import com.prolificinteractive.materialcalendarview.DayViewFacade;
//
//import java.util.Calendar;
//import java.util.Date;
//
//public class SaturdayDecorator {
//    private final Calendar calendar = Calendar.getInstance();
//    public SaturdayDecorator(){}
//
//   // @Override
//    public boolean shouldDecorate(CalendarDay day){
//        day.copyTo(calendar);
//        int weekDay=calendar.get(Calendar.DAY_OF_WEEK);
//        return weekDay==Calendar.SATURDAY;
//    }
//
//    //@Override
//    public void decorate(DayViewFacade view){
//        view.addSpan(new ForegroundColorSpan(Color.BLUE));
//    }
//}
