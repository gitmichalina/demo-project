package org.example.timereaderrework;

import java.util.Map;

public class Treader {


    private int hour;
    private int minute;
    private String partOfDay;

    public void setHourToRead(int hourToRead) {
        this.hourToRead = hourToRead;
    }

    private int hourToRead;
    private boolean isFullHour;


    public Treader(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
        setFullHour(minute);
        setPartOfDay(hour);
        this.hourToRead = hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid number");
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid number");
        }
        this.minute = minute;
    }

    public void setFullHour(int minute) {
        if (minute == 0) {
            isFullHour = true;
        } else {
            isFullHour = false;
        }
    }

    public void setPartOfDay(int hour) {
        if (this.hour > 11 && this.hour < 24) {
            this.partOfDay = " PM";
        } else {
            this.partOfDay = " AM";
        }
    }

    public String getPartOfDay() {
        return partOfDay;
    }

    public String readMinute() {
        String result = "";
        if (minute == 30) {
            result = "half past ";
            return result;
        }
        if (minute > 30) {
            result = translateNumberToString(60 - minute) + " to ";
            hourToRead = hourToRead + 1;
        }
        if (minute < 30) {
            result = translateNumberToString(minute) + " past ";
        }

        return result;
    }


    public String readHour() {
        String result = "";

        if (hourToRead == 12) {
            result = "midday";
        }
        if (hourToRead == 24) {
            result = "midnight";
        }

        if (hourToRead != 12 && hourToRead != 24) {
            result = translateNumberToString(to12hFormat(hourToRead)) + getPartOfDay();
        }
        return result;
    }

    private int to12hFormat(int hour) {
        if (hour > 12 && hour < 25) {
            hour -= 12;
        }
        if (hour == 25) {
            hour -= 24;
        }
        return hour;
    }

    public String read() {
        String result = "";

        if (isFullHour) {
            result = readHour();
        } else {
            result = readMinute() + readHour();
        }
        return result;
    }

    private String translateNumberToString(int number) {
        Map<Integer, String> values = Map.ofEntries(
                Map.entry(1, "one"),
                Map.entry(2, "two"),
                Map.entry(3, "three"),
                Map.entry(4, "four"),
                Map.entry(5, "five"),
                Map.entry(6, "six"),
                Map.entry(7, "seven"),
                Map.entry(8, "eight"),
                Map.entry(9, "nine"),
                Map.entry(10, "ten"),
                Map.entry(11, "eleven"),
                Map.entry(12, "twelve"),
                Map.entry(13, "thirteen"),
                Map.entry(14, "fourteen"),
                Map.entry(15, "fifteen"),
                Map.entry(16, "sixteen"),
                Map.entry(17, "seventeen"),
                Map.entry(18, "eighteen"),
                Map.entry(19, "nineteen"),
                Map.entry(20, "twenty"),
                Map.entry(21, "twenty one"),
                Map.entry(22, "twenty two"),
                Map.entry(23, "twenty three"),
                Map.entry(24, "twenty four"),
                Map.entry(25, "twenty five"),
                Map.entry(30, "thirty"),
                Map.entry(40, "fourty"),
                Map.entry(50, "fifty")
        );
        return values.get(number);
    }
}