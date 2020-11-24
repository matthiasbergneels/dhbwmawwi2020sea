package lecture.chapter5;

public class Car {

    // innere Enumeration (geschachtelt)
    public enum Brands{
        MERCEDES,
        BMW,
        DACIA,
        FORD,
        TESLA
    }

    // Attribute (Eigenschaften) für Objekte des Typs "Car" (Auto)
    private String color;           // --> private: nur innerhalb der Klasse / Objekt
    private String licensePlate;
    private int horsePower;
    public final Brands brand;
    private double currentSpeed;

    public static final String[] ALLOWED_COLOR = {"BLACK", "RED", "GREEN", "PURPEL"};

    // privates Klassenattribut zum zählen der Autos
    private static int carCounter;

    // Sichtbarkeits-Modifier für Attribute / Methoden (/ Klasse)
    // - private: Sichtbar innerhalb Klasse / Objekt
    //   default: Sichtbar innherlab des Pakets (Java package)
    // # protected: Sichtbar innherlab des Pakets (Java package)
    // + public: Überall Sichtbar

    // Konstruktor für "Car"
    public Car(String licensePlate, String color, int horsePower, Brands brand){

        // DRY --> Don't repeat yourself --> wiederverwenden von Code über Methoden
        this.setColor(color);
        this.setLicensePlate(licensePlate);
        this.setHorsePower(horsePower);
        this.brand = brand;
        this.currentSpeed = 0.0;
        carCounter++;
    }

    // Methoden (Verhalten) für Objekte des Typs "Car" (Auto)
    public void accelerate(double speedDelta){
        this.currentSpeed = this.currentSpeed + speedDelta;
        System.out.println("Das Auto fährt " + this.currentSpeed + " km/h");
    }

    public void brake(double speedDelta){
        this.currentSpeed = this.currentSpeed - speedDelta;
        System.out.println("Das Auto fährt " + this.currentSpeed + " km/h");
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
    public void setColor(String color){
        this.color = ALLOWED_COLOR[0];
        for(int i = 0; i < ALLOWED_COLOR.length; i++){
            if(color.equals(ALLOWED_COLOR[i])){
                this.color = color;
                break;
            }
        }
        /*
        if(parameterColor == "black" ||
            parameterColor == "red" ||
            parameterColor == "green"){
            color = parameterColor;
        }else{
            color = "black";
        }
         */
    }

    public void setHorsePower(int horsePower){
        if(horsePower > 35 && horsePower < 500){
            this.horsePower = horsePower;
        }else{
            this.horsePower = 100;
        }
    }

    private void setLicensePlate(String licensePlate){
        // TODO: Plausibilitätscheck für Nummernschilder z.B. REGEX ("XX-XX #####")
        this.licensePlate = licensePlate;
    }


    public static int getCarCounter(){
        return carCounter;
    }

    protected void finalize() {
        carCounter--;
        System.out.println("Das Auto " + this.licensePlate + " wird verschrottet!");
    }
}
