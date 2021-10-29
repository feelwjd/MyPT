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

//    @SerializedName("routineid")
//    @Expose
//    private int routineid;
//
//    @SerializedName("UserRoutineId")
//    @Expose
//    private int UserRoutineId;

    @SerializedName("RoutineDate")
    @Expose
    private String RoutineDate;

//    @SerializedName("Time")
//    @Expose
//    private String Time;
//
//    @SerializedName("workoutid")
//    @Expose
//    private String workoutid;
//
//    @SerializedName("routinename")
//    @Expose
//    private String routinename;
//
//    @SerializedName("description")
//    @Expose
//    private String description;

    @SerializedName("workoutname")
    @Expose
    private String workoutname;

    public String getUserid() {
        return userid;
    }

//    public int getRoutineid() {
//        return routineid;
//    }
//
//    public int getUserRoutineId() {
//        return UserRoutineId;
//    }
//
public String getRoutineDate() {
    LocalDate date = LocalDate.parse(RoutineDate, inputFormatter);
    String formattedDate = outputFormatter.format(date);
    return formattedDate;
}
//
//    public String getTime() {
//        return Time;
//    }
//
//    public String getWorkoutid() {
//        return workoutid;
//    }
//
//    public String getRoutinename() {
//        return routinename;
//    }
//
//    public String getDescription() {
//        return description;
//    }

    public String getWorkoutname() {
        return workoutname;
    }


}
