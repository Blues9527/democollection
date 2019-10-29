package com.example.hyfdemo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 14:23
 */

public class TimeFormatUtil {

    public static void main(String[] args) {
//        System.out.println(formatTime(1571659200000L));
        DateFormat df = new SimpleDateFormat("yyyy年 MM月 dd日 hh:mm");
        String time = df.format(new Date(1571666400000L));
        System.out.println(time);
    }

//    public static String formatTime(long duration) {
//
//        String time;
//
//        long minute = duration / 60;
//        long second = duration % 60;
//
//        if (minute < 10) {
//            if (second == 0) {
//                time = String.format("0%s'", minute);
//            } else {
//                time = String.format("0%s'%s\"", minute, second);
//            }
//        } else {
//            if (second == 0) {
//                time = String.format("%s'", minute);
//            } else {
//                time = String.format("%s'%s\"", minute, second);
//            }
//        }
//        return time;
//    }

    public static String formatTime(long time) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int second = calendar.get(Calendar.SECOND);


        return String.format("%s年 %s月 %s日 %s:%s", year, month, date, hour, second);
    }
}
