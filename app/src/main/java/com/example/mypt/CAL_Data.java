package com.example.mypt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CAL_Data {
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
        return RoutineDate;
    }
//

    public String getWorkoutname() {
        return workoutname;
    }


}
