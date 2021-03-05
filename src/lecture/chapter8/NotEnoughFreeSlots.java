package lecture.chapter8;

public class NotEnoughFreeSlots extends Exception{
    public int freeSlots;

    public NotEnoughFreeSlots(int requestedSlots, int freeSlots){
        super("Es wurde versucht " + requestedSlots + " Slots zu buchen; freie Slots " + freeSlots);
        this.freeSlots = freeSlots;
    }

}
