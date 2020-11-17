package lecture.chapter5;

public class Car {

    // Attribute (Eigenschaften) für Objekte des Typs "Car" (Auto)
    String color;
    String licensePlate;
    int horsePower;
    double currentSpeed;

    // Konstruktor für "Car"
    Car(String parameterLicensePlate, String parameterColor, int parameterHorsePower){
        color = parameterColor;
        licensePlate = parameterLicensePlate;
        horsePower = parameterHorsePower;
        currentSpeed = 0.0;
    }

    // Methoden (Verhalten) für Objekte des Typs "Car" (Auto)
    void accelerate(double speedDelta){
        currentSpeed = currentSpeed + speedDelta;
        System.out.println("Das Auto fährt " + currentSpeed + " km/h");
    }

    void brake(double speedDelta){
        currentSpeed = currentSpeed - speedDelta;
        System.out.println("Das Auto fährt " + currentSpeed + " km/h");
    }


}
