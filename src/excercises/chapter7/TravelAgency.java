package excercises.chapter7;

public class TravelAgency {

    public static void main(String[] args) {

        Bookable[] canBeBooked = new Bookable[5];


        Hotel myHotel = new Hotel(250);

        System.out.println("Freie Zimmer myHotel: " + myHotel.freeSlots());
        myHotel.book(100);
        myHotel.clean();

        // Call by Reference --> Referenz zu Objekt "hinter" myHotel wird in das Bookable Array übergeben
        // mit narrowing cast --> Sichtbarkeit auf Methoden des Bookable Interfaces
        canBeBooked[0] = myHotel;

        System.out.println("Freie Zimmer myHotel (wissen wir aber nicht): " + canBeBooked[0].freeSlots());
        canBeBooked[0].book(149);

        canBeBooked[1] = new Plane(80);
        canBeBooked[2] = new Plane(150);
        canBeBooked[3] = new Hotel(80);
        canBeBooked[4] = new Plane(10);


        for(Bookable toBookSomething : canBeBooked){
            System.out.println("Freie Plätze: " + toBookSomething.freeSlots());
            boolean successfullBooked = toBookSomething.book(50);
            if(!successfullBooked){
                toBookSomething.book(toBookSomething.freeSlots());
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
