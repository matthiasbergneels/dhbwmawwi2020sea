package test.lecture.chapter7;

import lecture.chapter7.Hotel;
import lecture.chapter8.NotEnoughFreeSlots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void bookSlotThrowsNotEnoughFreeSlotsExceptionWithExternalClass() {
        assertThrows(NotEnoughFreeSlots.class, new NotEnoughFreeSlotsExceptionExecution());
    }

    @Test
    void bookSlotThrowsNotEnoughFreeSlotsExceptionWithLambdaFunction() {
        Hotel myHotel = new Hotel(100);

        NotEnoughFreeSlots notEnoughFreeSlots = assertThrows(NotEnoughFreeSlots.class, () -> {
            myHotel.bookSlot(101);
        });

        assertEquals(100, notEnoughFreeSlots.freeSlots);

    }
}