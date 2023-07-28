package org.example.timereader;

import java.util.Map;

class TimeReader {


    public String getTime(int hour, int minute) {



        String timeOfDay;
        if (hour > 11 && hour < 24) {
            timeOfDay = "PM";
        } else {
            timeOfDay = "AM";
        }


        if (minute == 0) {
            return translate(to12hFormat(hour)) + " " + timeOfDay;
        } else {
            return translate(minute) + " past " + translate(to12hFormat(hour)) + " " + timeOfDay;
        }
    }

    private String translate(int number) {

        Map<Integer, String> values = Map.of(

                5, "five",
                9, "nine",
                11, "eleven",
                12, "twelve",
                20, "twenty",
                25, "twenty five",
                17, "seventeen"

        );
        return values.get(number);
    }

    private int to12hFormat(int hour) {

        if (hour > 12) {
            hour -= 12;
        }
        return hour;
    }
}
