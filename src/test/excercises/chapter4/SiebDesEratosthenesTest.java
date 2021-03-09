package test.excercises.chapter4;

import excercises.chapter4.SiebDesEratosthenes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SiebDesEratosthenesTest {

    @Test
    @DisplayName("Check Primzahlen calculation till 120")
    void calculatePrimzahlenArray() {
        boolean[] primzahlen = SiebDesEratosthenes.calculatePrimzahlenArray(120);

        for(int i = 0; i < primzahlen.length; i++){
            assertEquals(checkForPrimzahl(i), primzahlen[i]);
        }
    }



    // Testmethoden für Validierungsmethoden sollten eigentlich nicht nötig sein :-)
    @ParameterizedTest(name="{0} should be Primzahl")
    @ValueSource(ints = {0, 1, 2, 3, 5, 7, 11})
    void checkForPrimzahlTest(int numberA){
        assertTrue(checkForPrimzahl(numberA));
    }

    // Testmethoden für Validierungsmethoden sollten eigentlich nicht nötig sein :-)
    @ParameterizedTest(name="{0} should not be Primzahl")
    @ValueSource(ints = {4, 6, 8, 9, 10, 12})
    void checkForNotPrimzahlTest(int numberA){
        assertFalse(checkForPrimzahl(numberA));
    }


    private boolean checkForPrimzahl(int numberA){

        int divisor = 2;

        while(divisor < numberA){
            if(numberA % divisor++ ==  0){
                return false;
            }
        }

        return true;
    }
}