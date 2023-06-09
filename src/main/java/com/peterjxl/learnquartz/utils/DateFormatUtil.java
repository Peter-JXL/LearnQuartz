package com.peterjxl.learnquartz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date) {
        return sdf.format(date);
    }
}
