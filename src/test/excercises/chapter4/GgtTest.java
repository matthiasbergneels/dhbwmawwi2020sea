package test.excercises.chapter4;

import excercises.chapter4.Ggt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GgtTest {

    @ParameterizedTest(name="GGT of {0} and {1} should be {2}")
    @DisplayName("Calculation of GGT")
    @CsvSource({
            "6, 2, 2",
            "10, 3, 1",
            "245, 63, 7"
    })
    void calculateGgt(int numberA, int numberB, int result) {
        assertEquals(Ggt.calculateGgt(numberA, numberB), result);
    }
}