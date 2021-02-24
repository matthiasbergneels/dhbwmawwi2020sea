package excercises.chapter7;

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

    public int freeSlots(boolean reserve){
        // TODO: reserve slots
        return freeSlots();
    }

    @Override
    public boolean book(int slots){
        if(freeSlots() >= slots){
            for(int i = 0; i < seats.length; i++){
                if(!seats[i]){
                    seats[i] = true;
                    slots--;
                }

                if(slots == 0){
                    return true;
                }
            }
        }

        return false;
    }


}
