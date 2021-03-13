package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class MyCalendar {

    private GregorianCalendar calendar;

    private List<DayOffInfo> dayOffInfoList = new ArrayList<>();

    public MyCalendar(int day, int month, int year) {
        calendar = new GregorianCalendar(year, month, day);
    }

    public void addDayOffInfo() {
        DayOffInfo dayOffInfo = new DayOffInfo(calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.DAY_OF_WEEK));
        dayOffInfoList.add(dayOffInfo);
    }

    public void addDayOffInfo(String holidayName) {
        DayOffInfo dayOffInfo = new DayOffInfo(calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.DAY_OF_WEEK),
                holidayName);
        dayOffInfoList.add(dayOffInfo);
    }

    public List<DayOffInfo> getDayOffInfoList() {
        return dayOffInfoList;
    }

    public class DayOffInfo {

        private int day;

        private int month;

        private int year;

        private DayOfWeek dayWeek;

        private String name;

        public DayOffInfo(int day, int month, int year, int dayWeek, String name) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayWeek = DayOfWeek.getDay(dayWeek);
            this.name = name;
        }

        public DayOffInfo(int day, int month, int year, int dayWeek) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayWeek = DayOfWeek.getDay(dayWeek);
        }

        @Override
        public String toString() {
            if (name == null) {
                return "Выходной:\n" +
                        "Дата: " + day + "." + (month + 1) + "." + year + "\n" +
                        "День недели: " + dayWeek + "\n";
            }
            return "Праздник:\n" +
                    "Дата: " + day + "." + (month + 1) + "." + year + "\n" +
                    "День недели: " + dayWeek + "\n" +
                    "Наименование: " + name;
        }
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar( 13, Calendar.MARCH, 2021);
        calendar.addDayOffInfo();
        System.out.println(calendar.getDayOffInfoList().get(0).toString());
    }
}
