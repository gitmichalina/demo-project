package org.example.timereader;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeReaderTest {

    TimeReader unit = new TimeReader();

    @Test
    void whenGivenInvalidHour_shouldThrowIllegalArgumentException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            unit.read(25, 12);
        });
        String expectedMessage = "Invalid number. Set number between 1 to 24";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGivenInvalidMinute_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            unit.read(24, 60);
        });
        String expectedMessage = "Invalid number. Set number between 0 to 59";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGiven11h_shouldReadElevenAM() {

        Assertions.assertEquals("eleven AM", unit.read(11, 0));
    }

    @Test
    void whenGiven15h_shouldThreeThreePM() {

        Assertions.assertEquals("three PM", unit.read(15, 0));
    }

    @Test
    void whenGiven11h25_shouldReadTwentyFivePastEleven() {

        Assertions.assertEquals("twenty five past eleven AM", unit.read(11, 25));
    }

    @Test
    void whenGiven15h25m_shouldReadTwentyFivePastThreePM() {

        Assertions.assertEquals("twenty five past three PM", unit.read(15, 25));
    }

    @Test
    void whenGiven10h35m_shouldReadTwentyFiveToElevenAM() {

        Assertions.assertEquals("twenty five to eleven AM", unit.read(10, 35));
    }

    @Test
    void whenGiven15h35m_shouldReadTwentyFiveToFourPM() {

        Assertions.assertEquals("twenty five to four PM", unit.read(15, 35));
    }

    @Test
    void whenGiven11h30_shouldReadHalfPastElevenAM() {

        Assertions.assertEquals("half past eleven AM", unit.read(11, 30));
    }

    @Test
    void whenGiven15h30_shouldReadHalfPastThreePM() {

        Assertions.assertEquals("half past three PM", unit.read(15, 30));
    }

    @Test
    void whenGiven12h_shouldReadMidday() {

        Assertions.assertEquals("midday", unit.read(12, 0));
    }

    @Test
    void whenGiven24h_shouldReadMidnight() {

        Assertions.assertEquals("midnight", unit.read(24, 0));
    }

    @Test
    void whenGiven12h25m_shouldReadTwentyFivePastTwelve() {

        Assertions.assertEquals("twenty five past twelve PM", unit.read(12, 25));
    }

    @Test
    void whenGiven11h35m_shouldReadTwentyFiveToTwelvePM() {

        Assertions.assertEquals("twenty five to twelve PM", unit.read(11, 35));
    }

    @Test
    void whenGiven12h30m_shouldReadHalfPastTwelvePM() {

        Assertions.assertEquals("half past twelve PM", unit.read(12, 30));
    }

    @Test
    void whenGiven12h35m_shouldReadTwentyFiveToOnePm() {

        Assertions.assertEquals("twenty five to one PM", unit.read(12, 35));
    }


    @Test
    void whenGiven24h25m_shouldReadTwentyFivePastTwelveAM() {

        Assertions.assertEquals("twenty five past twelve AM", unit.read(24, 25));
    }

    @Test
    void whenGiven23h35m_shouldReadTwentyFiveToTwelveAM() {

        Assertions.assertEquals("twenty five to twelve AM", unit.read(23, 35));
    }


    @Test
    void whenGiven23h35m_shouldReadTwentyFivePastElevenPM() {

        Assertions.assertEquals("twenty five past eleven PM", unit.read(23, 25));
    }


    @Test
    void whenGiven24h30m_shouldReadHalfPastTwelveAMt() {

        Assertions.assertEquals("half past twelve AM", unit.read(24, 30));
    }

    @Test
    void whenGiven24h35m_shouldReadTwentyFiveToOneAm() {

        Assertions.assertEquals("twenty five to one AM", unit.read(24, 35));
    }


}