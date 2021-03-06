package com.numero.sojodia.util;

import com.numero.sojodia.model.Time;

import java.util.Calendar;

public class TimeUtil {

    public static Time setCurrentTime(Time time) {
        Calendar calendar = Calendar.getInstance();
        time.hour = calendar.get(Calendar.HOUR_OF_DAY);
        time.min = calendar.get(Calendar.MINUTE);
        time.sec = calendar.get(Calendar.SECOND);
        return time;
    }

    public static Time initCurrentTime() {
        Time time = new Time();
        Calendar calendar = Calendar.getInstance();
        time.hour = calendar.get(Calendar.HOUR_OF_DAY);
        time.min = calendar.get(Calendar.MINUTE);
        time.sec = calendar.get(Calendar.SECOND);
        return time;
    }

    public static Time addition(Time before, Time after) {
        Time time = new Time();
        time.sec = before.sec + after.sec;
        time.min = before.min + after.min;
        time.hour = before.hour + after.hour;

        time.min += time.sec / 60;
        time.sec = time.sec % 60;
        time.hour += time.min / 60;
        time.min = time.min % 60;
        time.hour = time.hour % 24;

        return time;
    }

    public static Time subtraction(Time before, Time after) {
        Time time = new Time();
        time.sec = before.sec - after.sec;
        time.min = before.min - after.min;
        time.hour = before.hour - after.hour;

        if (time.sec < 0) {
            time.sec = 60 + time.sec;
            time.min--;
        }

        if (time.min < 0) {
            time.min = 60 + time.min;
            time.hour--;
        }

        if (time.hour < 0) {
            time.hour = 24 + time.hour;
        }
        return time;
    }

    public static Time getCountTime(Time before) {
        Time time = new Time();
        Time currentTime = initCurrentTime();
        time.sec = before.sec - currentTime.sec;
        time.min = before.min - currentTime.min;
        time.hour = before.hour - currentTime.hour;

        if (time.sec < 0) {
            time.sec = 60 + time.sec;
            time.min--;
        }

        if (time.min < 0) {
            time.min = 60 + time.min;
            time.hour--;
        }

        if (time.hour < 0) {
            time.hour = 24 + time.hour;
        }
        return time;
    }

    public static boolean isOverTime(Time before, Time after) {
        Time time = new Time();
        time.sec = after.sec - before.sec;
        time.min = after.min - before.min;
        time.hour = after.hour - before.hour;

        if (time.sec < 0) {
            time.sec = 60 + time.sec;
            time.min--;
        }

        if (time.min < 0) {
            time.min = 60 + time.min;
            time.hour--;
        }

        return time.hour >= 0;
    }

}
