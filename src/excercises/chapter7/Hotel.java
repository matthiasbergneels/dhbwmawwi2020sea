package excercises.chapter7;

public class Hotel implements Bookable{

    private int roomCount;
    private int bookedRoomCount;

    public Hotel(int roomCount){
        this.roomCount = roomCount;
        this.bookedRoomCount = 0;
    }

    @Override
    public int freeSlots(){
        return roomCount - bookedRoomCount;
    }

    @Override
    public boolean book(int slots){
        if(freeSlots() >= slots){
            bookedRoomCount += slots;
            return true;
        }

        return false;
    }
}
