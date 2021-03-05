package test.lecture.chapter7;

import lecture.chapter7.Hotel;
import org.junit.jupiter.api.function.Executable;

public class NotEnoughFreeSlotsExceptionExecution implements Executable {

    @Override
    public void execute() throws Throwable {
        Hotel myHotel = new Hotel(100);

        myHotel.bookSlot(101);
    }
}
