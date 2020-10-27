package com.example.mydemo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @data on 2020/10/26 5:07 PM
 * @auther
 * @describe
 */
public class DateUtil2 {
    /**
     * 时间戳按规则转成发布时间
     * @param timeStamps 13位时间戳
     * @return
     */
    public static String getTimeFormatText(long timeStamps) {
        long minute = 60 * 1000;// 1分钟
        long hour = 60 * minute;// 1小时
        long day = 24 * hour;// 1天

        long diff = System.currentTimeMillis() - timeStamps;
        long r = 0;
        if (diff > day * 6) {  //五天前，都用日期表示
            return stampToDate(timeStamps);
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(long timeStamps){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(new Date(timeStamps));
        String year = dateStr.substring(0,4);
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        if (String.valueOf(curYear).equals(year)) {
            //日期为当年，截取掉年份
            return dateStr.substring(5);
        } else {
            //日期不为当年
            return dateStr;
        }
    }
}
