package lecture.chapter5;

public class Car {

    // Attribute (Eigenschaften) für Objekte des Typs "Car" (Auto)
    private String color;           // --> private: nur innerhalb der Klasse / Objekt
    private String licensePlate;
    private int horsePower;
    private double currentSpeed;

    // Sichtbarkeits-Modifier für Attribute / Methoden (/ Klasse)
    // - private: Sichtbar innerhalb Klasse / Objekt
    //   default: Sichtbar innherlab des Pakets (Java package)
    // # protected: Sichtbar innherlab des Pakets (Java package)
    // + public: Überall Sichtbar

    // Konstruktor für "Car"
    public Car(String parameterLicensePlate, String parameterColor, int parameterHorsePower){

        // DRY --> Don't repeat yourself --> wiederverwend von Code über Methoden
        setColor(parameterColor);
        setLicensePlate(parameterLicensePlate);
        setHorsePower(parameterHorsePower);
        currentSpeed = 0.0;
    }

    // Methoden (Verhalten) für Objekte des Typs "Car" (Auto)
    public void accelerate(double speedDelta){
        currentSpeed = currentSpeed + speedDelta;
        System.out.println("Das Auto fährt " + currentSpeed + " km/h");
    }

    public void brake(double speedDelta){
        currentSpeed = currentSpeed - speedDelta;
        System.out.println("Das Auto fährt " + currentSpeed + " km/h");
    }

    // Getter- / Setter-Methoden

    // Kapselung --> Lese-Zugriff Attribute über get-Methoden
    public String getLicensePlate(){
        return licensePlate;
    }

    public String getColor(){
        return color;
    }

    public int getHorsePower(){
        return horsePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    // Kapselung --> Schreib-Zugriff Attribute über set-Methoden
    public void setColor(String parameterColor){
        if(parameterColor == "black" ||
            parameterColor == "red" ||
            parameterColor == "green"){
            color = parameterColor;
        }else{
            color = "black";
        }
    }

    public void setHorsePower(int parameterHorsePower){
        if(parameterHorsePower > 35 && parameterHorsePower < 500){
            horsePower = parameterHorsePower;
        }else{
            horsePower = 100;
        }
    }

    private void setLicensePlate(String parameterLicensePlate){
        // TODO: Plausibilitätscheck für Nummernschilder
        licensePlate = parameterLicensePlate;
    }

}
