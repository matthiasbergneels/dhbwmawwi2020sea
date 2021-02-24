package test.excercises.exkurs.junit;

import excercises.exkurs.junit.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator myCalculator;
    double result = 0;

    @BeforeEach
    void setUp() {
        myCalculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        result = 0;
    }

    @Test
    @DisplayName("adding two numbers")
    void add() {
        result = myCalculator.add(5.0, 10.0);
        Assertions.assertEquals(15.0, result);
    }

    @Test
    @DisplayName("adding two numbers with different result")
    void addWrongResult() {
        result = myCalculator.add(5.0, 10.0);
        Assertions.assertNotEquals(20.0, result);
    }

    @Test
    @DisplayName("adding two large numbers")
    void addVeryLargeNumbers() {
        result = myCalculator.add(50000000000000000000.0, 10.0);
        Assertions.assertEquals(50000000000000000010.0, result);
    }

    @Test
    @DisplayName("substract two numbers")
    void substract(){
        result = myCalculator.substract(5.0, 10.0);
        Assertions.assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("multiply two numbers")
    void multiply(){
        result = myCalculator.multiply(3.0, 10.0);
        Assertions.assertEquals(30.0, result);
    }

}