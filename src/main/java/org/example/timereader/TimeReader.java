package org.example.timereader;

import java.util.Map;

public class TimeReader {

    public TimeReader() {
    }

    private void checkMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid number. Set number between 0 to 59");
        }
    }

    private void checkHour(int hour) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid number. Set number between 1 to 24");
        }
    }

    private boolean isFullHour(int minute) {
        if (minute == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String getPartOfDay(int hour, int minute) {

        if (hour == 23 && minute > 30) {
            return " AM";
        } else if (hour == 11 && minute > 30) {
            return " PM";
        } else if (hour > 11 && hour < 24) {
            return " PM";
        } else {
            return " AM";
        }
    }

    private int getHourToRead(int hour, int minute) {
        int result = hour;

        if (minute > 30)
            result = hour + 1;

        return result;
    }

    private String readMinute(int minute) {
        String result = "";
        if (minute == 30) {
            result = "half past ";
            return result;
        }
        if (minute > 30) {
            result = translateNumberToString(60 - minute) + " to ";
        }

        if (minute < 30) {
            result = translateNumberToString(minute) + " past ";
        }

        return result;
    }

    private String readHour(int hour, int minute) {
        String result = "";

        if (isFullHour(minute) && getHourToRead(hour, minute) == 12) {
            result = "midday";
        } else if (isFullHour(minute) && getHourToRead(hour, minute) == 24) {
            result = "midnight";
        } else {
            result = translateNumberToString(to12hFormat(getHourToRead(hour, minute))) + getPartOfDay(hour, minute);
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

    public String read(int hour, int minute) {
        checkMinute(minute);
        checkHour(hour);

        String result = "";

        if (isFullHour(minute)) {
            result = readHour(hour, minute);
        } else {
            result = readMinute(minute) + readHour(hour, minute);
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