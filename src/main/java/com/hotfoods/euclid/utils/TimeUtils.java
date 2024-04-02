package com.hotfoods.euclid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getSTRTimeSec(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


}
