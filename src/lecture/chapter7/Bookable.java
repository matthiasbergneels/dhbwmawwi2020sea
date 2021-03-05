package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlots;

public interface Bookable {

    public int freeSlots();
    public void bookSlot(int slots) throws NotEnoughFreeSlots;

}
