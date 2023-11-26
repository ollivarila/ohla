package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    @ParameterizedTest(name="Sec: {0} = {1}")
    @CsvSource({ "-1, -1", "0, 0:00:00", "36000, 10:00:00", "5, 0:00:05", "65, 0:01:05", "5, 0:00:05", "3665, 1:01:05", "360000, 100:00:00", "10, 0:00:10", "600, 0:10:00" })
    void testSecToTime(int secs, String result){
        String res = TimeUtils.secToTime(secs);
        assertEquals(result, res);
    }


}