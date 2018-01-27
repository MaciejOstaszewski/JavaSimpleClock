package Logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JOptionPane;

public class Watch {

    private GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final DateFormat timeFormat = new SimpleDateFormat("kk:mm:ss");

    public Watch() {

        timeFormat.setTimeZone(TimeZone.getTimeZone("Poland"));
        getStystemTime();
    }

    public Watch(int year, int month, int day, int hour, int minute, int second) {
        calendar = new GregorianCalendar(year, month, day, hour, minute, second);
    }

    public Watch(int year, int month, int day) {
        calendar = new GregorianCalendar(year, month, day);
    }

    public void getStystemTime() {

        calendar.setTimeInMillis(System.currentTimeMillis());

    }

    public void getSystemDate() {
        Date date = new Date();
        calendar.setTime(date);
    }

    public void getInstance() {
        calendar = (GregorianCalendar) Calendar.getInstance();

    }

    public void addSecond() {
        calendar.add(Calendar.SECOND, 1);
    }

    public void subMonth() {
        calendar.add(Calendar.MONTH, -1);
    }

    public String printTime() {
        return timeFormat.format(calendar.getTime());
    }

    public String printDate() {
        return dateFormat.format(calendar.getTime());
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    public void setYear(int year) {
        this.calendar.set(Calendar.YEAR, year);
    }

    public void setMonth(int month) {
        this.calendar.set(Calendar.MONTH, month);
    }

    public void setDay(int day) {
        this.calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setHour(int Hour) {
        this.calendar.set(Calendar.HOUR_OF_DAY, Hour);
    }

    public void setMinute(int Minute) {
        this.calendar.set(Calendar.MINUTE, Minute);
    }

    public void setSecond(int second) {
        this.calendar.set(Calendar.SECOND, second);
    }
}
