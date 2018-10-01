package br.edu.ifpr.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeUtils
{
    private static final String PT_BR_DATE_PATTERN = "dd/MM/yyyy";
    
    public static String formatDate(java.util.Date date, String pattern) {
        return (new SimpleDateFormat(pattern)).format(date);
     }

     public static java.util.Date parseDate(String date, String pattern) {
        java.util.Date d = null;

        try { d = (new SimpleDateFormat(pattern)).parse(date); }
        catch (ParseException ex) {}

        return d;
     }

     public static java.util.Date parseDate(String date) {
        return parseDate(date,PT_BR_DATE_PATTERN);
     }

     public static java.util.Date parseDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();

        c.set(year,month,day);

        return c.getTime();
     }

     public static java.util.Date parseDateFromYear(int year) {
        Calendar c = Calendar.getInstance();

        c.setTime(getDate());
        c.set(Calendar.YEAR,year);

        return c.getTime();
     }

     public static java.util.Date parseDateFromMonth(int month) {
        Calendar c = Calendar.getInstance();

        c.setTime(getDate());
        c.set(Calendar.MONTH,month);

        return c.getTime();
     }

     public static java.util.Date parseDateFromDay(int day) {
        Calendar c = Calendar.getInstance();

        c.setTime(getDate());
        c.set(Calendar.DAY_OF_MONTH,day);

        return c.getTime();
     }

     public static java.util.Date getDate() {
        return new java.util.Date();
     }

     public static java.util.Date getDate(int year, int month, int day) {
        return (new GregorianCalendar(year,month,day)).getTime();
     }

     public static java.util.Date addYears(java.util.Date date, int years) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(Calendar.YEAR,years);

        return c.getTime();
     }

     public static java.util.Date nowPlusYears(int years) {
        return addYears(getDate(),years);
     }

     public static java.util.Date addMonths(java.util.Date date, int months) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(Calendar.MONTH,months);

        return c.getTime();
     }

     public static java.util.Date nowPlusMonths(int months) {
        return addMonths(getDate(),months);
     }

     public static java.util.Date addDays(java.util.Date date, int days) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH,days);

        return c.getTime();
     }

     public static java.util.Date nowPlusDays(int days) {
        return addDays(getDate(),days);
     }

     public static java.util.Date addDate(java.util.Date aDate,
                                          java.util.Date bDate) {
        Calendar c = Calendar.getInstance();

        c.setTime(new java.util.Date(aDate.getTime() + bDate.getTime()));

        return c.getTime();
     }

     public static java.util.Date sqlDateToDate(java.sql.Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
     }

     public static java.sql.Date dateToSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
     }
}
