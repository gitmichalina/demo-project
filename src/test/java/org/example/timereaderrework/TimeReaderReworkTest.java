package org.example.timereaderrework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeReaderReworkTest {

    @Test
    void whenGivenInvalidHourToTheConstructor_shouldThrowExc() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeReaderRework(25, 12));
        String expectedMessage = "Invalid number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenGivenInvalidMinuteToTheConstructor_shouldThrowExc() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeReaderRework(24, 60));
        String expectedMessage = "Invalid number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenGiven11h_shouldReadElevenAM() {

        TimeReaderRework unit = new TimeReaderRework(11, 0);
        Assertions.assertEquals("eleven AM", unit.read());
    }

    @Test
    void whenGiven15h_shouldThreeElevenPM() {

        TimeReaderRework unit = new TimeReaderRework(15, 0);
        Assertions.assertEquals("three PM", unit.read());
    }

    @Test
    void whenGiven24h_shouldReadMidnight() {

        TimeReaderRework unit = new TimeReaderRework(24, 0);
        Assertions.assertEquals("midnight", unit.read());
    }

    @Test
    void whenGiven12h_shouldReadMidday() {

        TimeReaderRework unit = new TimeReaderRework(12, 0);
        Assertions.assertEquals("midday", unit.read());
    }

    @Test
    void whenGivenExact30Minutes_shouldReadHalfPast() {

        TimeReaderRework unit = new TimeReaderRework(5, 30);
        Assertions.assertEquals("half past five AM", unit.read());
    }


    @Test
    void whenGiven24h30m_shouldReadHalfPastMidnight() {

        TimeReaderRework unit = new TimeReaderRework(24, 30);
        Assertions.assertEquals("half past midnight", unit.read());
    }
    @Test
    void whenGiven24h25m_shouldReadTwentyFivePastMidnight() {

        TimeReaderRework unit = new TimeReaderRework(24, 25);
        Assertions.assertEquals("twenty five past midnight", unit.read());
    }

    @Test
    void whenGiven24h35m_shouldReadTwentyFiveToOneAm() {

        TimeReaderRework unit = new TimeReaderRework(24, 35);
        Assertions.assertEquals("twenty five to one AM", unit.read());
    }

    @Test
    void whenGiven11h35m_shouldReadTwentyFiveToMidday() {

        TimeReaderRework unit = new TimeReaderRework(11, 35);
        Assertions.assertEquals("twenty five to midday", unit.read());
    }

    @Test
    void whenGiven23h35m_shouldReadTwentyFiveToMidnighty() {

        TimeReaderRework unit = new TimeReaderRework(23, 35);
        Assertions.assertEquals("twenty five to midnight", unit.read());
    }

    @Test
    void whenGiven17h23_shouldReadTwentyFivePastFive() {

        TimeReaderRework unit = new TimeReaderRework(17, 25);
        Assertions.assertEquals("twenty five past five PM", unit.read());
    }

    @Test
    void whenGiven11h23_shouldReadTwentyFivePastTen() {

        TimeReaderRework unit = new TimeReaderRework(11, 9);
        Assertions.assertEquals("nine past eleven AM", unit.read());
    }

    @Test
    void whenGiven9h35_shouldReadTwentyFiveToTen() {

        TimeReaderRework unit = new TimeReaderRework(9, 35);
        Assertions.assertEquals("twenty five to ten AM", unit.read());
    }
}