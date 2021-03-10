package excercises.chapter8;

import static excercises.chapter8.AutoSitz.SeatColor.*;

public class AutoSitzManufaktur {

    public static void main(String[] args) {
        try {
            AutoSitz validSeat1 = new AutoSitz(false, RED);
            AutoSitz validSeat2 = new AutoSitz(true, BLACK);
            AutoSitz validSeat3 = new AutoSitz(true, BLUE);
        } catch(FalscheParameter e){
            System.out.println(e.getMessage());
        }
    }
}
