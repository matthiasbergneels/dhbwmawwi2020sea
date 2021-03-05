package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlots;

public class Plane implements Bookable{

    private boolean[] seats;

    public Plane(int seatCount){
        seats = new boolean[seatCount];
    }

    public void fly(){
        System.out.println("und ich flieg, flieg, flieg... ");
    }

    @Override
    public int freeSlots(){
        int freeSlots = 0;
        for(boolean seat : seats){
            if(!seat){
                freeSlots++;
            }
        }

        return freeSlots;
    }

    @Override
    public void bookSlot(int slots) throws NotEnoughFreeSlots {
        if(freeSlots() < slots){
            throw new NotEnoughFreeSlots(slots, freeSlots());
        }

        for(int i = 0; i < seats.length; i++){
            if(!seats[i]){
                seats[i] = true;
                slots--;
            }

            if(slots == 0){
                return;
            }
        }


    }


}
