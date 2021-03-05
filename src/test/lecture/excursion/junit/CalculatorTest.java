package test.lecture.excursion.junit;

import lecture.excursion.junit.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test")
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

    @DisplayName("add-method Tests")
    @Nested
    class addTest{
        @Test
        @DisplayName("adding two numbers")
        void add() {
            result = myCalculator.add(5.0, 10.0);
            assertEquals(15.0, result);
        }

        @Test
        @DisplayName("adding two numbers with different result")
        void addWrongResult() {
            result = myCalculator.add(5.0, 10.0);
            assertNotEquals(20.0, result);
        }

        @Test
        @DisplayName("adding two large numbers")
        @Tag("Integration")
        void addVeryLargeNumbers() {
            result = myCalculator.add(50000000000000000000.0, 10.0);
            assertEquals(50000000000000000010.0, result);
        }
    }



    @Test
    @DisplayName("subtract two numbers")
    void subtract(){
        result = myCalculator.subtract(5.0, 10.0);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("multiply two numbers")
    void multiply(){
        result = myCalculator.multiply(3.0, 10.0);
        assertEquals(30.0, result);
    }

}