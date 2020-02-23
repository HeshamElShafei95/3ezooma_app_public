package net.rajpals.common.java;


import android.text.format.DateUtils;

import net.rajpals.common.CommonConstants;
import net.rajpals.common.LibApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static net.rajpals.common.utilities.CommonUtilities.changeIntegerToProperString;

public final class DateTimeUtility {
    public static final TimeZone utcTZ = TimeZone.getTimeZone("UTC");
    //Local formatting String
    public static final String LOCAL_DF_TIME12_1 = "dd-MM-yyyy h:mm a";
    public static final String LOCAL_DF_TIME24_1 = "dd-MM-yyyy H:mm";
    public static final String LOCAL_DF_TIME12_COMMAS = "MMM dd,yyyy h:mm a";
    public static final String LOCAL_DF_TIME12_DD_MMM_YYYY_COMMAS = "dd MMM, yyyy h:mm a";
    public static final String LOCAL_DF_TIME24_COMMAS = "MMM dd,yyyy H:mm";
    //UTC formatted String
    public static final String UTC_DF_TIME24_1 = "yyyy-MM-dd H:mm";
    public static final String UTC_DF_TIME12_1 = "yyyy-MM-dd h:mm";
    //Simple Date Format
    public static final String DATE_F_MMM_DD_YYYY = "MMM-dd-yyyy";
    public static final String DATE_F_DD_MMM_YYYY = "dd MMM yyyy";
    public static final String DATE_F_SLASH_DD_MMM_YYYY = "dd/MM/yyyy";
    public static final String DATE_F_MMM_DD_YYYY_COMMAS = "MMM dd,yyyy";
    public static final String DATE_F_DD_MMM_YYYY_COMMAS = "dd MMM, yyyy";
    public static final String DATE_F_DD_MM_YYYY = "dd-MM-yyyy";
    public static final String DATE_F_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_SERVER = "yyyy-MM-dd HH:mm:ss";
    //TIME FORMAT
    public static final String TIME_24 = "HH:mm";
    public static final String TIME_12 = "hh:mm a";
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;
    private static String TAG = DateTimeUtility.class.getName();



    public static String convertUTCFormatToLocal(String utcDateString, String currentUtcDateFormat, String requiredDateFormat) {
        //Convert UTC : 2016-11-22 10:39 To local : 22-11-2016 4:09 PM
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(currentUtcDateFormat, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(utcTZ);
        Date date = null;
        try {
            date = simpleDateFormat.parse(utcDateString);
            utcDateString = new SimpleDateFormat(requiredDateFormat, Locale.ENGLISH).format(date);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return utcDateString;
    }

    public static long convertUTCFormatToLocalTimeMilli(String utcDateString, String currentUtcDateFormat) {
        //Convert UTC : 2016-11-22 10:39 To local : 22-11-2016 4:09 PM
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(currentUtcDateFormat, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(utcTZ);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(utcDateString);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return date.getTime();
    }

    public static String convertLocalToUTC(String utcDateString, String currentLocalDateFormat, String requiredDateFormat) {
        //Convert local to UTC format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(currentLocalDateFormat);
        Date date = null;
        try {
            date = simpleDateFormat.parse(utcDateString);
            SimpleDateFormat utcDateFormat = new SimpleDateFormat(requiredDateFormat);
            utcDateFormat.setTimeZone(utcTZ);
            utcDateString = utcDateFormat.format(date);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return utcDateString;
    }

    //CONVERT DATE TO DESIRE FORMAT
    public static String convertDateToNewFormat(Date date, String newFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(date);
    }

    public static String getCurrentUTCDate(String requiredDateFormat) {
        //Get Current date in UTC FORMAT
        final Date currentTime = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat(requiredDateFormat);
        sdf.setTimeZone(utcTZ);
        return sdf.format(currentTime);
    }

    public static String getCurrentLocalDate(String requiredDateFormat) {
        //Get Current date in UTC FORMAT
        final Date currentTime = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat(requiredDateFormat);
        return sdf.format(currentTime);
    }

    // change from dd-MM-yyyy to MM-dd-YYYY
    public static String convertDateFromOldToNewFormat(String dateString, String oldFormat, String newFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat, Locale.ENGLISH);
        try {
            Date date = sdf.parse(dateString);
            sdf.applyPattern(newFormat);
            return sdf.format(date);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return dateString;
    }

    // Time conversion 24 HH to 12
    public static String convertTimeFormat(String timeString, String oldTimeFormat, String newTimeFormat) {
        try {
            SimpleDateFormat oldTimeFormatter = new SimpleDateFormat(oldTimeFormat);
            SimpleDateFormat newTimeFormatter = new SimpleDateFormat(newTimeFormat);
            Date newDate = oldTimeFormatter.parse(timeString);
            return newTimeFormatter.format(newDate);
        } catch (Exception ex) {
            LibApp.showException(TAG, ex);
        }
        return timeString;
    }

    public static String buildDate(int y, int m, int d, String requiredFormat) {
        String buildSting = d + "-" + (m + 1) + "-" + y;
        return convertDateFromOldToNewFormat(buildSting, DATE_F_DD_MM_YYYY, requiredFormat);
    }

    //Rider start Date and time
    public static String[] getDayMonth(String date) {
        String[] days = new String[3];
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_F_YYYY_MM_DD, Locale.ENGLISH);

        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        try {
            localCalendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Date currentTime = localCalendar.getTime();
        int currentDay = localCalendar.get(Calendar.DATE);
        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
        days[0] = Integer.toString(currentDay); //date
        days[1] = CommonConstants.days[currentDayOfWeek]; // day of week
        days[2] = CommonConstants.months[currentMonth];  //mon
        return days;
    }

    public static Calendar getCalender(String date, boolean isTomorrow) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_F_YYYY_MM_DD, Locale.ENGLISH);
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        try {
            localCalendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        if (isTomorrow)
            localCalendar.add(Calendar.DAY_OF_YEAR, 1);

        return localCalendar;
    }

    public static String getCurrentDate(String date, boolean isTomorrow) {
        Calendar localCalendar;
        if (date == null) {
            localCalendar = Calendar.getInstance();
        } else {
            localCalendar = getCalender(date, isTomorrow);
        }
        return localCalendar.get(Calendar.YEAR) + "-"
                + changeIntegerToProperString(localCalendar.get(Calendar.MONTH) + 1) + "-"
                + changeIntegerToProperString(localCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Integer compareDates(String str1, String str2, String format) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date date1 = formatter.parse(str1);
            Date date2 = formatter.parse(str2);
            return date1.compareTo(date2);

        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static String getCurrentTime() {
        Calendar localCalendar;
        localCalendar = Calendar.getInstance();

        return localCalendar.get(Calendar.HOUR_OF_DAY)
                + ":" + localCalendar.get(Calendar.MINUTE);

    }

    public static List<Date> getDates(List<String> list, String format) {
        List<Date> dateList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            for (String dateS : list) {
                Date date = formatter.parse(dateS);
                dateList.add(date);
            }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return dateList;
    }

    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = getCurrentTimeMillis();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " mins";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return diff / DAY_MILLIS + " days";
        }
    }

    public static String getOnlineTimeAgo(long time) {
        long now = getCurrentTimeMillis();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return diff / 1000 + "s";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + "m";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + "m";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return diff / HOUR_MILLIS + "h";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + "h";
        } else if (diff < 48 * HOUR_MILLIS) {
            return diff / DAY_MILLIS + "d";
        } else {
            return diff / DAY_MILLIS + "d";
        }
    }

    private static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }


    public static String chatTimeFormatter(String createdAt) {
//2018-08-28 10:43:13
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_SERVER, Locale.ENGLISH);
        try {
            //   sdf.setTimeZone(utcTZ);
            Date date = sdf.parse(createdAt);
            sdf.setTimeZone(TimeZone.getDefault());

            if (isToday(date)) {
                sdf.applyPattern("hh:mma");
                return sdf.format(date);

            }
            sdf.applyPattern("dd, MMM-yy hh:mma");
            return sdf.format(date);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return createdAt;

    }

    private static String chatFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd, MMM-yy hh:mma", Locale.ENGLISH);
        format.setTimeZone(utcTZ);
        return format.format(date);
    }

    private static String todayChatFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mma", Locale.ENGLISH);
        format.setTimeZone(utcTZ);
        return format.format(date);
    }

    private static boolean isToday(Date date) {
        return DateTimeUtility.isToday(date.getTime());
    }

    private static boolean isToday(long time) {
        return DateUtils.isToday(time);
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_SERVER, Locale.ENGLISH);
        sdf.setTimeZone(utcTZ);
        return sdf.format(System.currentTimeMillis());
    }

    public static String formatSeenTime(String time) {
        //2019-01-22 15:19:33
        return convertDateFromOldToNewFormat(time, DATE_TIME_FORMAT_SERVER, "dd MMM, hh:mm a");
    }

    public static String starTimeFormat(String starMsgTime) {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_SERVER, Locale.ENGLISH);
        try {
            //   sdf.setTimeZone(utcTZ);
            Date date = sdf.parse(starMsgTime);
            sdf.setTimeZone(TimeZone.getDefault());

            if (isToday(date)) {
                sdf.applyPattern("hh:mma");
                return sdf.format(date);

            }
            sdf.applyPattern("dd/MM/yy");
            return sdf.format(date);
        } catch (ParseException ex) {
            LibApp.showException(TAG, ex);
        }
        return starMsgTime;

    }
}