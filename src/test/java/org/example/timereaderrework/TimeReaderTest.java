package org.example.timereaderrework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeReaderTest {

    @Test
    void whenGivenInvalidHourToTheConstructor_shouldThrowIllegalArgumentException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeReader(25, 12));
        String expectedMessage = "Invalid number. Set number between 1 to 24";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGivenInvalidMinuteToTheConstructor_shouldThrowIllegalArgumentException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeReader(24, 60));
        String expectedMessage = "Invalid number. Set number between 0 to 59";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGiven11h_shouldReadElevenAM() {

        TimeReader unit = new TimeReader(11, 0);
        Assertions.assertEquals("eleven AM", unit.read());
    }

    @Test
    void whenGiven15h_shouldThreeThreePM() {

        TimeReader unit = new TimeReader(15, 0);
        Assertions.assertEquals("three PM", unit.read());
    }

    @Test
    void whenGiven11h25_shouldReadTwentyFivePastEleven() {

        TimeReader unit = new TimeReader(11, 25);
        Assertions.assertEquals("twenty five past eleven AM", unit.read());
    }

    @Test
    void whenGiven15h25m_shouldReadTwentyFivePastThreePM() {

        TimeReader unit = new TimeReader(15, 25);
        Assertions.assertEquals("twenty five past three PM", unit.read());
    }

    @Test
    void whenGiven10h35m_shouldReadTwentyFiveToElevenAM() {

        TimeReader unit = new TimeReader(10, 35);
        Assertions.assertEquals("twenty five to eleven AM", unit.read());
    }

    @Test
    void whenGiven15h35m_shouldReadTwentyFiveToFourPM() {

        TimeReader unit = new TimeReader(15, 35);
        Assertions.assertEquals("twenty five to four PM", unit.read());
    }

    @Test
    void whenGiven11h30_shouldReadHalfPastElevenAM() {

        TimeReader unit = new TimeReader(11, 30);
        Assertions.assertEquals("half past eleven AM", unit.read());
    }

    @Test
    void whenGiven15h30_shouldReadHalfPastThreePM() {

        TimeReader unit = new TimeReader(15, 30);
        Assertions.assertEquals("half past three PM", unit.read());
    }



    @Test
    void whenGiven12h_shouldReadMidday() {

        TimeReader unit = new TimeReader(12, 0);
        Assertions.assertEquals("midday", unit.read());
    }

    @Test
    void whenGiven24h_shouldReadMidnight() {

        TimeReader unit = new TimeReader(24, 0);
        Assertions.assertEquals("midnight", unit.read());
    }

    @Test
    void whenGiven12h25m_shouldReadTwentyFivePastTwelve() {

        TimeReader unit = new TimeReader(12, 25);
        Assertions.assertEquals("twenty five past twelve PM", unit.read());
    }

    @Test
    void whenGiven11h35m_shouldReadTwentyFiveToTwelvePM() {

        TimeReader unit = new TimeReader(11, 35);
        Assertions.assertEquals("twenty five to twelve PM", unit.read());
    }

    @Test
    void whenGiven12h30m_shouldReadHalfPastTwelvePM() {

        TimeReader unit = new TimeReader(12, 30);
        Assertions.assertEquals("half past twelve PM", unit.read());
    }

    @Test
    void whenGiven12h35m_shouldReadTwentyFiveToOnePm() {

        TimeReader unit = new TimeReader(12, 35);
        Assertions.assertEquals("twenty five to one PM", unit.read());
    }



    @Test
    void whenGiven24h25m_shouldReadTwentyFivePastTwelveAM() {

        TimeReader unit = new TimeReader(24, 25);
        Assertions.assertEquals("twenty five past twelve AM", unit.read());
    }

    @Test
    void whenGiven23h35m_shouldReadTwentyFiveToTwelveAM() {

        TimeReader unit = new TimeReader(23, 35);
        Assertions.assertEquals("twenty five to twelve AM", unit.read());
    }


    @Test
    void whenGiven23h35m_shouldReadTwentyFivePastElevenPM() {

        TimeReader unit = new TimeReader(23, 25);
        Assertions.assertEquals("twenty five past eleven PM", unit.read());
    }


    @Test
    void whenGiven24h30m_shouldReadHalfPastTwelveAMt() {

        TimeReader unit = new TimeReader(24, 30);
        Assertions.assertEquals("half past twelve AM", unit.read());
    }

    @Test
    void whenGiven24h35m_shouldReadTwentyFiveToOneAm() {

        TimeReader unit = new TimeReader(24, 35);
        Assertions.assertEquals("twenty five to one AM", unit.read());
    }


}