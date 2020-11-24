package lecture.chapter5;

public class Student {

    private String name;
    private String familyName;
    private int studentNo;

    // Überladen von Methoden
    public void drink(double amount){
        System.out.println("Studierende trinkt " + amount + " ml.");
    }

    public void drink(double amount, double alcoholPercentage){
        //System.out.println("Studierende trinkt " + amount + " ml.");
        this.drink(amount);
        System.out.println("und wird immer betrunkener.");
    }

    public void drink(double fluidAmount, boolean isPoison){
        // --> MethodenSignatur: void drink(double, boolean)
        this.drink(fluidAmount);
        if(isPoison){
            System.out.println("und stirbt! XXX");
        }
    }

    public void drink(boolean isTranquilizer, double amount){
        this.drink(amount);
        if(isTranquilizer){
            System.out.println("und schläft");
        }
    }

    public void drink(double amount, double alcoholPercentage, boolean isPoison){
        this.drink(amount, alcoholPercentage);
        if(isPoison){
            System.out.println("und stirbt! XXX");
        }
    }
}
