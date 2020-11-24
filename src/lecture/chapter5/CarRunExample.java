package lecture.chapter5;

public class CarRunExample {

    public static void main(String[] args) {

        System.out.println("Es gibt " + Car.getCarCounter() + " Autos.");

        // Deklaration einer Variable vom Typ "Car"
        Car myCar;
        Car yourCar;

        // erzeugen eines Car Objektes (Instanz) und referenzieren
        // in der Variable myCar
        myCar = new Car("MA XY-1234", "RED", 160, Car.Brands.TESLA);

        System.out.println("Es gibt " + Car.getCarCounter() + " Autos.");



        // interagieren mit dem Objekt (Instanz)
        // über Referenzvariable "myCar" --> Methoden
        myCar.accelerate(350.0);
        myCar.brake(5.0);
        myCar.brake(3.0); // Code: --> myCar.brake(3.0);

        System.out.println("myCar, Leistung: " + myCar.getHorsePower());
        System.out.println("myCar, Farbe: " + myCar.getColor());
        System.out.println("myCar, Nummernschild: " + myCar.getLicensePlate());
        System.out.println("myCar, Marke: " + myCar.brand);

        myCar.setColor("kack-braun");
        myCar.setHorsePower(550);

        //myCar.licensePlate = "Geht dich nichts an";

        System.out.println("myCar fährt gerade: " + myCar.getCurrentSpeed() + "km/h");
        System.out.println("myCar hat die Farbe " + myCar.getColor());


        // neues Objekt (Instanz) von Typ "Car" (Auto)
        yourCar = new Car("HD MM-9876", "green", 99, Car.Brands.FORD);

        System.out.println("Es gibt " + Car.getCarCounter() + " Autos.");

        String colorGreen = new String("GREEN");    //"GREEN";
        System.out.println("Farbe wird: " + colorGreen);

        yourCar.setColor(colorGreen);
        yourCar.setHorsePower(99);
        //yourCar.licensePlate = "HD MM-9876";
        System.out.println("yourCar hat die Farbe " + yourCar.getColor());

        System.out.println("yourCar fährt gerade: " + yourCar.getCurrentSpeed() + " km/h");

        yourCar.accelerate(100.0);
        yourCar.brake(2.0);
        yourCar.brake(5.0);

        System.out.println("yourCar fährt gerade: " + yourCar.getCurrentSpeed() + " km/h");


        Car carOne = new Car("HD-XY 5678",
                "GREEN", 150, Car.Brands.MERCEDES);
        Car carTwo = new Car("MA-ZZ 5672",
                "RED", 200, Car.Brands.MERCEDES);
        Car carThree = new Car("HD-XY 5678",
                "GREEN", 150, Car.Brands.MERCEDES);
        Car carFour = carTwo;  // Call by Reference (!)


        System.out.println("carOne == carTwo: " + (carOne == carTwo));            // false
        System.out.println("carOne == carThree: " + (carOne == carThree));        // false (!)
        System.out.println("carOne == carFour: " + (carOne == carFour));          // false
        System.out.println("carTwo == carFour: " + (carTwo == carFour));          // true


        System.out.println("Es gibt " + Car.getCarCounter() + " Autos.");

        System.out.println("Es gibt " + myCar.getCarCounter() + " Autos.");


        // Garbage Collector

        // --> altes Objekt von myCar wird "unreachable" wenn
        // ein neues Objekt erzeugt wird und in der
        // Referenzvariable gespeichert wird
        myCar = new Car("HD-HH 5728", "RED",
                299, Car.Brands.FORD);

        // Besser: Referenzvariable initialisieren mit null
        myCar = null;
        yourCar = null;
        carTwo = null;

        //myCar.accelerate(50.0);

        // Bitte an den Garbage Collector um aufzuräumen
        System.gc();

        try {
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("Schlafen ist schief gegangen!");
        }

        System.out.println("Es gibt " + Car.getCarCounter() + " Autos.");
    }
}
