package com.jeevic.servlet.demo.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @className: com.jeevic.servlet.demo.utils -> DateUtils
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/26 20:40
 * @version: 1.0
 */
public class DateUtils {
    static final ZoneId GMT = ZoneId.of("Z");

    public static long parseDateTimeGMT(String s) {
        ZonedDateTime zdt = ZonedDateTime.parse(s, DateTimeFormatter.RFC_1123_DATE_TIME);
        return zdt.toInstant().toEpochMilli();
    }

    public static String formatDateTimeGMT(long ts) {
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(ts), GMT);
        return zdt.format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }
}
