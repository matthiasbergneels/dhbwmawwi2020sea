package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlots;

public class TravelAgency {

    public static void main(String[] args) {

        Bookable[] canBeBooked = new Bookable[5];

        Hotel myHotel = new Hotel(250);

        System.out.println("Freie Zimmer myHotel: " + myHotel.freeSlots());
        try {
            myHotel.bookSlot(251);

            myHotel.clean();

            // Call by Reference --> Referenz zu Objekt "hinter" myHotel wird in das Bookable Array übergeben
            // mit narrowing cast --> Sichtbarkeit auf Methoden des Bookable Interfaces
            canBeBooked[0] = myHotel;

            System.out.println("Freie Zimmer myHotel (wissen wir aber nicht): " + canBeBooked[0].freeSlots());
            canBeBooked[0].bookSlot(149);

        }catch(NotEnoughFreeSlots notEnoughFreeSlots){
            System.out.println("Ausnahme ist aufgetreten");
            System.out.println(notEnoughFreeSlots.getMessage());

            notEnoughFreeSlots.printStackTrace(System.out);
        }catch(Exception e){
            System.out.println("Eine andere Ausnahme ist aufgetreten - haben wir so nicht erwartet.");
            return;
        }

        canBeBooked[0] = myHotel;
        canBeBooked[1] = new Plane(80);
        canBeBooked[2] = new Plane(150);
        canBeBooked[3] = new Hotel(80);
        canBeBooked[4] = new Plane(10);

        for(Bookable toBookSomething : canBeBooked){
            System.out.println("Freie Plätze: " + toBookSomething.freeSlots());
            try {
                toBookSomething.bookSlot(50);
            }catch(NotEnoughFreeSlots notEnoughFreeSlots){
                System.out.println(notEnoughFreeSlots.getMessage());
                System.out.println("Wir buchen die restlichen freien Plätzen ("
                        + notEnoughFreeSlots.freeSlots + ")");
                try {
                    toBookSomething.bookSlot(notEnoughFreeSlots.freeSlots);
                }catch (NotEnoughFreeSlots notEnoughFreeSlots1){
                    System.out.println("Schon wieder zu wenig Platz! Ich geb auf!");
                }

            }
            System.out.println("Freie Plätze nach dem Buchen: " + toBookSomething.freeSlots());

            if(toBookSomething instanceof Plane){
                // widening Cast
                Plane myPlane = (Plane)toBookSomething;
                myPlane.fly();
            }
        }
    }
}
