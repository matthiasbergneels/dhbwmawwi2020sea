package lecture.chapter5;

public class CarRunExample {

    public static void main(String[] args) {

        // Deklaration einer Variable vom Typ "Car"
        Car myCar;
        Car yourCar;

        // erzeugen eines Car Objektes (Instanz) und referenzieren
        // in der Variable myCar
        myCar = new Car("MA XY-1234", "black", 160);

        // interagieren mit dem Objekt (Instanz)
        // über Referenzvariable "myCar" --> Methoden
        myCar.accelerate(350.0);
        myCar.brake(5.0);
        myCar.brake(3.0); // Code: --> myCar.brake(3.0);

        System.out.println("myCar, Leistung: " + myCar.getHorsePower());
        System.out.println("myCar, Farbe: " + myCar.getColor());
        System.out.println("myCar, Nummernschild: " + myCar.getLicensePlate());

        myCar.setColor("kack-braun");
        myCar.setHorsePower(550);
        //myCar.licensePlate = "Geht dich nichts an";

        System.out.println("myCar fährt gerade: " + myCar.getCurrentSpeed() + "km/h");
        System.out.println("myCar hat die Farbe " + myCar.getColor());


        // neues Objekt (Instanz) von Typ "Car" (Auto)
        yourCar = new Car("HD MM-9876", "green", 99);

        yourCar.setColor("green");
        yourCar.setHorsePower(99);
        //yourCar.licensePlate = "HD MM-9876";

        System.out.println("yourCar fährt gerade: " + yourCar.getCurrentSpeed() + " km/h");

        yourCar.accelerate(100.0);
        yourCar.brake(2.0);
        yourCar.brake(5.0);

        System.out.println("yourCar fährt gerade: " + yourCar.getCurrentSpeed() + " km/h");

    }
}
