package org.example.timereaderrework;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreaderTest {

    @Test
    void whenGivenInvalidHourToTheConstructor_shouldThrowExc() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Treader(25, 12));
        String expectedMessage = "Invalid number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenGivenInvalidMinuteToTheConstructor_shouldThrowExc() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Treader(24, 60));
        String expectedMessage = "Invalid number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void whenGiven11h_shouldReadElevenAM() {

        Treader unit = new Treader(11, 0);
        Assertions.assertEquals("eleven AM", unit.read());
    }

    @Test
    void whenGiven11h25_shouldReadTwentyFivePastEleven() {

        Treader unit = new Treader(11, 25);
        Assertions.assertEquals("twenty five past eleven AM", unit.read());
    }

    @Test
    void whenGiven10h35m_shouldReadTwentyFiveToElevenAM() {

        Treader unit = new Treader(10, 35);
        Assertions.assertEquals("twenty five to eleven AM", unit.read());
    }

    @Test
    void whenGiven11h30_shouldReadHalfPastElevenAM() {

        Treader unit = new Treader(11, 30);
        Assertions.assertEquals("half past eleven AM", unit.read());
    }

    @Test
    void whenGiven15h30_shouldReadHalfPastThreePM() {

        Treader unit = new Treader(15, 30);
        Assertions.assertEquals("half past three PM", unit.read());
    }


    @Test
    void whenGiven15h_shouldThreeElevenPM() {

        Treader unit = new Treader(15, 0);
        Assertions.assertEquals("three PM", unit.read());
    }

    @Test
    void whenGiven15h35m_shouldReadTwentyFiveToFourPM() {

        Treader unit = new Treader(15, 35);
        Assertions.assertEquals("twenty five to four PM", unit.read());
    }

    @Test
    void whenGiven15h25m_shouldReadTwentyFivePastThreePM() {

        Treader unit = new Treader(15, 25);
        Assertions.assertEquals("twenty five past three PM", unit.read());
    }



    @Test
    void whenGiven12h_shouldReadMidday() {

        Treader unit = new Treader(12, 0);
        Assertions.assertEquals("midday", unit.read());
    }

    @Test
    void whenGiven12h25m_shouldReadTwentyFivePastMidday() {

        Treader unit = new Treader(12, 25);
        Assertions.assertEquals("twenty five past midday", unit.read());
    }

    @Test
    void whenGiven11h35m_shouldReadTwentyFiveToMidday() {

        Treader unit = new Treader(11, 35);
        Assertions.assertEquals("twenty five to midday", unit.read());
    }

    @Test
    void whenGiven12h30m_shouldReadHalfPastMidday() {

        Treader unit = new Treader(12, 30);
        Assertions.assertEquals("half past midday", unit.read());
    }

    @Test
    void whenGiven12h35m_shouldReadTwentyFiveToOnePm() {

        Treader unit = new Treader(12, 35);
        Assertions.assertEquals("twenty five to one PM", unit.read());
    }


    @Test
    void whenGiven24h_shouldReadMidnight() {

        Treader unit = new Treader(24, 0);
        Assertions.assertEquals("midnight", unit.read());
    }

    @Test
    void whenGiven24h25m_shouldReadTwentyFivePastMidnight() {

        Treader unit = new Treader(24, 25);
        Assertions.assertEquals("twenty five past midnight", unit.read());
    }

    @Test
    void whenGiven23h35m_shouldReadTwentyFiveToMidnight() {

        Treader unit = new Treader(23, 35);
        Assertions.assertEquals("twenty five to midnight", unit.read());
    }

    @Test
    void whenGiven24h30m_shouldReadHalfPastMidnight() {

        Treader unit = new Treader(24, 30);
        Assertions.assertEquals("half past midnight", unit.read());
    }


    @Test
    void whenGiven24h35m_shouldReadTwentyFiveToOneAm() {

        Treader unit = new Treader(24, 35);
        Assertions.assertEquals("twenty five to one AM", unit.read());
    }























}