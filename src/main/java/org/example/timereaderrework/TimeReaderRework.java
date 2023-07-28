package org.example.timereaderrework;

import java.util.Map;

class TimeReaderRework {

    private int hour;
    private int minute;
    private boolean isMidnight;
    private boolean isMidday;
    private boolean isFullHour;
    private boolean is30PlusMinutes = false;
    private String partOfDay;
    private boolean isLessThan30mtoMidnight = false;
    private boolean isLessThan30mtoMidday = false;

    public TimeReaderRework(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
        setMidnight(hour);
        setMidday(hour);
        setIsFullHour(minute);
        setIs30PlusMinutes(minute);
        setPartOfDay(hour);
        setIsLessThan30mtoMidnight(hour, minute);
        setIsLessThan30mtoMidday(hour, minute);
    }

    public String getPartOfDay() {
        return partOfDay;
    }

    private void setHour(int hour) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid number");
        }
        this.hour = hour;
    }

    private void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid number");
        }
        this.minute = minute;
    }

    public void setMidnight(int hour) {
        if (hour == 24) {
            this.isMidnight = true;
        } else {
            this.isMidnight = false;
        }
    }

    public void setMidday(int hour) {
        if (hour == 12) {
            this.isMidday = true;
        } else {
            this.isMidday = false;
        }
    }

    public void setIsFullHour(int minute) {
        if (this.minute == 0) {
            this.isFullHour = true;
        } else {
            this.isFullHour = false;
        }
    }

    public void setIs30PlusMinutes(int minute) {
        if (this.minute > 30) {
            this.is30PlusMinutes = true;
        }
    }
    public void setIsLessThan30mtoMidnight(int hour, int minute) {
        if (hour == 23 && is30PlusMinutes) {
            this.isLessThan30mtoMidnight = true;
        }
    }

    public void setIsLessThan30mtoMidday(int hour, int minute) {
        if (hour == 11 && is30PlusMinutes) {
            this.isLessThan30mtoMidday = true;
        }
    }

    public String readMinute() {

        String result = "";

        if (!is30PlusMinutes) {
            result = translateMinuteToString(minute) + " past ";
        }
        if (is30PlusMinutes) {
            result = translateMinuteToString(60 - minute) + " to ";
        }
        if (this.minute == 30) {
            result = "half past ";
        }
        return result;
    }

    public String readHour() {
        String result = "";

        if (isMidnight && is30PlusMinutes) {
            return translateMinuteToString(to12hFormat(hour + 1));
        }

        if (isLessThan30mtoMidnight || (!is30PlusMinutes && isMidnight)) {
            return "midnight";
        }

        if (isLessThan30mtoMidday || (!is30PlusMinutes && isMidday)) {
            return "midday";
        }



        if (is30PlusMinutes) {
            return translateMinuteToString(to12hFormat(hour + 1));
        }


        return translateMinuteToString(to12hFormat(hour));
    }


    public void setPartOfDay(int hour) {
        if (this.hour > 11 && this.hour < 24) {
            this.partOfDay = "PM";
        } else {
            this.partOfDay = "AM";
        }
    }

    private int to12hFormat(int hour) {
        int formattedHour = hour;
        if (hour > 12 && hour < 26) {
            formattedHour = hour - 12;
        }
        return formattedHour;
    }


    public String read() {

        String result = "koko";

        if (isFullHour && (isMidday || isMidnight))
            result = readHour();

        if (isFullHour && (!isMidday && !isMidnight))
            result = readHour() + " " + getPartOfDay();

        if (!isFullHour)
            result = readMinute() + readHour() + " " + getPartOfDay();

        if (!isFullHour && (isMidday || isMidnight))
            result = readMinute() + readHour();

        if(!isFullHour && (isLessThan30mtoMidnight || isLessThan30mtoMidday)){
            result = readMinute() + readHour();
        }

        return result;
    }


    private String translateMinuteToString(int number) {
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
