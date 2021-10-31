package com.example.mypt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class CAL_Data {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("RoutineDate")
    @Expose
    private String RoutineDate;

    @SerializedName("workoutname")
    @Expose
    private String workoutname;

    public String getUserid() {
        return userid;
    }

//
public String getRoutineDate() {
    LocalDate date = LocalDate.parse(RoutineDate, inputFormatter);
    String formattedDate = outputFormatter.format(date);
    return formattedDate;
}
//

    public String getWorkoutname() {
        return workoutname;
    }


}
