package test.excercises.chapter4;

import excercises.chapter4.Heron;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HeronTest {

    @ParameterizedTest(name="Calculate square root of {0} with precision of 0.0001")
    @DisplayName("Square Root calculation with Heron")
    @ValueSource(doubles = {4.0, 16.0, 20.0, 121})
    void calculateSquareRootWithHeron(double numberA) {
        double precision = 0.0001;

        assertTrue(Heron.calculateSquareRootWithHeron(numberA, precision) - Math.sqrt(numberA) < precision);
    }
}