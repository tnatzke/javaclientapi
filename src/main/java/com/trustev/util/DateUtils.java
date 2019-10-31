package com.trustev.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DEFAULT_TIME_ZONE = "UTC";


    public static String formatTimeStamp(Date d) {
        if (d == null) {
            return null;
        }
        DateFormat m_ISO8601Local = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        m_ISO8601Local.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIME_ZONE));

        return m_ISO8601Local.format(d);
    }
}
