package test.excercises.chapter4;

import excercises.chapter4.Fakultaet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FakultaetTest {

    private static final InputStream systemIn = System.in;
    private static final PrintStream systemOut = System.out;

    private static ByteArrayInputStream testIn;
    private static ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }

    void provideInputToSystemIn(String data){
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @ParameterizedTest(name="Factorial of {0} should be {1}")
    @DisplayName("Factorial calculation")
    @CsvSource({
            "1, 1",
            "3, 6",
            "4, 24",
            "5, 120",
            "10, 3628800"
    })
    void fakultaetMainTest(int input, int result){
        String expectedResult = "Fakultät von " + input + ": " + result + "\nFakultät ist: " + result;

        provideInputToSystemIn(Integer.toString(input));

        Fakultaet.main(new String[0]);

        assertEquals(expectedResult, testOut.toString().trim());
    }
}