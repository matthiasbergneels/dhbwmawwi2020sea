package lecture.chapter6;

public class Bird extends Animal{

    private boolean canFly;

    /*
    public Bird() {
        super(10.0f, "Vögelchen", 1.0f);
        setCanFly(true);
    }
     */

    public Bird(float size, String description, float weight, boolean canFly) {
        super(size, description, weight);
        setCanFly(canFly);
    }

    public void tweet(){
        System.out.println("Der Vogel " + getDescription() + " zwitschert.");
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}

