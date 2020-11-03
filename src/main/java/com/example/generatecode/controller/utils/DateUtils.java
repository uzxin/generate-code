package com.example.generatecode.controller.utils;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 */
public class DateUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_TIME_GETDATE = "yyyyMMddhhmmss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    public static String format(Object date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    public static long toMillSecendDay() {
        long l = System.currentTimeMillis();
        DateTime dateTime = DateTime.now().plusDays(1).withTime(0, 0, 0, 0);
        long time = dateTime.toDate().getTime();
        return time - l;
    }

    public static Date parseStrToDate(String date) {

        return parseStrToDate(date,DATE_TIME_PATTERN);
    }
    public static Date parseStrToDate(String date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {
                return df.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 根据传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     */
    public static String getDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 计算距离现在多久，非精确
     *
     * @param date
     * @return
     */
    public static String getTimeBefore(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        } else if (hour > 0) {
            r += hour + "小时";
        } else if (min > 0) {
            r += min + "分";
        } else if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 计算距离现在多久，精确
     *
     * @param date
     * @return
     */
    public static String getTimeBeforeAccurate(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        }
        if (hour > 0) {
            r += hour + "小时";
        }
        if (min > 0) {
            r += min + "分";
        }
        if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 更据时间 获取当天的 开始 或者 结束时间
     *
     * @param date
     * @param isStart
     * @return
     */
    public static Date getDayByDate(Date date, boolean isStart) {
        if (date == null) {
            return date;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        if (isStart) {
            format = format + " 00:00:00";
        } else {
            format = format + " 23:59:59";
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取开始时间
     *
     * @param date
     * @return
     */
    public static Date getStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);

        return todayStart.getTime();
    }

    /**
     * 获取结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 算出距今 天数的日期
     *
     * @param validDay 天数 (正数 几天以后)(负数 几天以前)
     * @return
     */
    public static Date getLaterDateByDay(Date date, Integer validDay) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DAY_OF_MONTH, validDay);
        return instance.getTime();
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(format(getEndTime(getLaterDateByDay(date,5)),DATE_TIME_PATTERN));
    }

}
