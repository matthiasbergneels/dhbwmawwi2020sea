package test.lecture.chapter8;

import lecture.chapter8.NotEnoughFreeSlots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotEnoughFreeSlotsTest {

    @Test
    void creatNotEnoughFreeSlotsException(){
        NotEnoughFreeSlots notEnoughFreeSlots = new NotEnoughFreeSlots(100, 50);
        assertEquals("Es wurde versucht 100 Slots zu buchen; freie Slots 50", notEnoughFreeSlots.getMessage());
        assertEquals(50, notEnoughFreeSlots.freeSlots);
    }

}