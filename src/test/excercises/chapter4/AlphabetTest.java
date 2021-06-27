package test.excercises.chapter4;

import excercises.chapter4.Alphabet;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut(systemOut);
    }

    @Test
    void alphabetMain(){
        String result = "Alphabet:\nA B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

        Alphabet.main(new String[0]);

        assertEquals(result, testOut.toString().trim());
    }
}