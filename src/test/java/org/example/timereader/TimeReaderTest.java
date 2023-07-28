package org.example.timereader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeReaderTest {

    @Test
    void whenGiven11h25_shouldReturnTwentyFivePastEleven(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("twenty five past five PM", unit.getTime(17, 25));
    }


    @Test
    void whenGivenAmHourReturnAM(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("twenty five past nine AM", unit.getTime(9, 25));

    }

    @Test
    void whenGivenPmHourReturnPM(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("twenty five past nine PM", unit.getTime(21, 25));

    }

    @Test
    void whenGivenFullHour_shouldNotReturnMinutes(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("nine AM", unit.getTime(9, 0));

    }

    @Test
    void shouldReturnActualTimeInStrings(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("five past eleven AM", unit.getTime(11, 5));

    }

    @Test
    void whenGiven12pmHourReturnTwelvePM(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("twenty five past twelve PM", unit.getTime(12, 25));

    }

    @Test
    void whenGiven30plusMinutesReturnMinutesToNextHour(){

        TimeReader unit = new TimeReader();
        Assertions.assertEquals("twenty five to one PM", unit.getTime(12, 35));

    }












}