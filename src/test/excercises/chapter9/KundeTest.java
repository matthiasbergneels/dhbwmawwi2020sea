package test.excercises.chapter9;

import excercises.chapter9.Kunde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KundeTest {

    private Kunde customer1;
    private Kunde customer2;
    private Kunde customer3;
    private Kunde customer4;

    @BeforeEach
    void setUp() {
        customer1 = new Kunde("Mueller", "Karl", 1234);
        customer2 = new Kunde("Schmidt", "Karl", 1234);
        customer3 = customer1;
        customer4 = new Kunde("Berger", "Fritz", 4567);
    }

    @Nested
    class EqualsTests{

        @Test
        void compareSimilarCustomersDifferentObjects(){
            assertTrue(customer1.equals(customer2));
        }

        @Test
        void compareSameObjects(){
            assertTrue(customer1.equals(customer3));
        }

        @Test
        void compareDifferentCustomers(){
            assertFalse(customer1.equals(customer4));
        }

    }

    @Nested
    class CompareToTests{

        @Test
        void compareSmallerWithBiggerCustomer(){
            int result = customer1.compareTo(customer4);
            assertTrue(result < 0);
        }

        @Test
        void compareSimilarCustomers(){
            int result = customer1.compareTo(customer2);
            assertTrue(result == 0);
        }

        @Test
        void compareBiggerWithSmallerCustomer(){
            int result = customer4.compareTo(customer1);
            assertTrue(result > 0);
        }
    }

    @Nested
    class HashCodeTests{

        @Test
        void hashCodeGenerateCustomer1(){
            assertEquals(customer1.getKundenNummer(), customer1.hashCode());
        }

        @Test
        void hashCodeSimilarCustomerDifferentObjects(){
            assertTrue(customer1.hashCode() == customer2.hashCode());
        }

        @Test
        void hashCodeCompareSameObjects(){
            assertTrue(customer1.hashCode() == customer3.hashCode());
        }

        @Test
        void hashCodecompareDifferentCustomers(){
            assertFalse(customer1.hashCode() == customer4.hashCode());
        }
    }

}