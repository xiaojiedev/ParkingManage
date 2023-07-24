package com.example.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Slf4j
public class DateUtils {

//    private static SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd-HH-mm:ss:ms");

    public static Date getNowDate(){
        return new Date();
    }

    public static int differentDays(String date1, String date2) {
        return differentDays(str2date(date1,"yyyy-MM-dd"), str2date(date2,"yyyy-MM-dd"));
    }

    public static int differentDays(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public static Date strConvertDate(String date){
        Date parse = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss:ms");
        if(StringUtils.isNotEmpty(date)){
            try {
                parse = sdf.parse(date);
            }catch (ParseException e){
                log.error("时间转化失败");
            }
        }
        return parse;
    }

    public static Date str2date(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String beforeStringDate(String date, int day, String pattern) {
        Date str2date = str2date(date, pattern);
        Date before = getDateBefore(str2date, day);
        String s = date2format(before, pattern);
        return s;
    }

    public static String date2format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String date2format(Date date) {
        return date2format(date,"yyyy-MM-dd");
    }

    public static Date getDateBefore(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    public static String getStrDateBefore(Date date, int day, String pattern) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        Date time = now.getTime();
        return date2format(time,pattern);
    }

    public static List<String> getDays(String startTime, String endTime, String format) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    public static void main(String[] args) {
        System.out.println(getDateBefore(new Date(), -2));

        for (String day : getDays( getStrDateBefore(new Date(), -5,"yyyy-MM-dd"), date2format(new Date()), "yyyy-MM-dd")) {
            System.out.println(day);
        }
    }
}
