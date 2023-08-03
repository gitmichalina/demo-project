package org.example.t3;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.function.Supplier;

class TreaderTest {

    public static final Supplier<LocalTime> TIME_NOW = LocalTime::now;
    public static final Supplier<LocalTime> TIME_NOT_NOW = ()-> LocalTime.of(22, 40);
    Treader unit = new Treader(TIME_NOT_NOW);


    @Test
    void whenGivenInvalidHour_shouldThrowIllegalArgumentException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            unit.read();
        });
        String expectedMessage = "Invalid number. Set number between 0 to 23";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGivenInvalidMinute_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            unit.read();
        });
        String expectedMessage = "Invalid number. Set number between 0 to 59";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenGiven11h40_shouldRead() {

//        Treader unit = new Treader(TIME_NOT_NOW); uzupelnic dla kazdego test

        Assertions.assertEquals("twenty to eleven PM", unit.read());
    }

    @Test
    void whenGiven11h_shouldReadElevenAM() {

        Assertions.assertEquals("eleven AM", unit.read());
    }

    @Test
    void whenGiven15h_shouldThreeThreePM() {

        Assertions.assertEquals("three PM", unit.read());
    }

    @Test
    void whenGiven11h25_shouldReadTwentyFivePastEleven() {

        Assertions.assertEquals("twenty five past eleven AM", unit.read());
    }

    @Test
    void whenGiven15h25m_shouldReadTwentyFivePastThreePM() {

        Assertions.assertEquals("twenty five past three PM", unit.read());
    }

    @Test
    void whenGiven10h35m_shouldReadTwentyFiveToElevenAM() {

        Assertions.assertEquals("twenty five to eleven AM", unit.read());
    }

    @Test
    void whenGiven15h35m_shouldReadTwentyFiveToFourPM() {

        Assertions.assertEquals("twenty five to four PM", unit.read());
    }

    @Test
    void whenGiven11h30_shouldReadHalfPastElevenAM() {

        Assertions.assertEquals("half past eleven AM", unit.read());
    }

    @Test
    void whenGiven15h30_shouldReadHalfPastThreePM() {

        Assertions.assertEquals("half past three PM", unit.read());
    }

    @Test
    void whenGiven12h_shouldReadMidday() {

        Assertions.assertEquals("midday", unit.read());
    }

    @Test
    void whenGiven0h_shouldReadMidnight() {

        Assertions.assertEquals("midnight", unit.read());
    }

    @Test
    void whenGiven12h25m_shouldReadTwentyFivePastTwelve() {

        Assertions.assertEquals("twenty five past twelve PM", unit.read());
    }

    @Test
    void whenGiven11h35m_shouldReadTwentyFiveToTwelvePM() {

        Assertions.assertEquals("twenty five to twelve PM", unit.read());
    }

    @Test
    void whenGiven12h30m_shouldReadHalfPastTwelvePM() {

        Assertions.assertEquals("half past twelve PM", unit.read());
    }

    @Test
    void whenGiven12h35m_shouldReadTwentyFiveToOnePm() {

        Assertions.assertEquals("twenty five to one PM", unit.read());
    }


    @Test
    void whenGiven0h25m_shouldReadTwentyFivePastTwelveAM() {

        Assertions.assertEquals("twenty five past twelve AM", unit.read());
    }

    @Test
    void whenGiven23h35m_shouldReadTwentyFiveToTwelveAM() {

        Assertions.assertEquals("twenty five to twelve AM", unit.read());
    }


    @Test
    void whenGiven23h35m_shouldReadTwentyFivePastElevenPM() {

        Assertions.assertEquals("twenty five past eleven PM", unit.read());
    }


    @Test
    void whenGiven24h30m_shouldReadHalfPastTwelveAMt() {

        Assertions.assertEquals("half past twelve AM", unit.read());
    }

    @Test
    void whenGiven24h35m_shouldReadTwentyFiveToOneAm() {

        Assertions.assertEquals("twenty five to one AM", unit.read());
    }
}