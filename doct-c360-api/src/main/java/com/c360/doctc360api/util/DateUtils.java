package com.c360.doctc360api.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
        // private constructor to hide the implicit public one
    }

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static Date addDays(Date date, int noOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, noOfDays);
        return cal.getTime();
    }
}
