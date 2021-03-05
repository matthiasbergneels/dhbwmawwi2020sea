package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlots;

public class Hotel implements Bookable{

    private int roomCount;
    private int bookedRoomCount;

    public Hotel(int roomCount){
        this.roomCount = roomCount;
        this.bookedRoomCount = 0;
    }


    public void clean (){
        System.out.println("und ich wisch, wisch, wisch... ");
    }


    @Override
    public int freeSlots(){
        return roomCount - bookedRoomCount;
    }

    @Override
    public void bookSlot(int slots) throws NotEnoughFreeSlots {
        if(freeSlots() >= slots){
            bookedRoomCount += slots;
        }else{
            throw new NotEnoughFreeSlots(slots, freeSlots());
        }
    }
}
