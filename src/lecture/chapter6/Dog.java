package lecture.chapter6;

import lecture.chapter5.Car;

public final class Dog extends Animal {

    private String breed;

    public Dog(float size, String description, float weight, String breed){
        super(size, description, weight);
        setBreed(breed);
    }

    public void bark(){
        System.out.println("Der Hund "+ getDescription() + " bellt!");
    }

    public String getBreed() {
        return breed;
    }

    /*
    public void move(){ --> final Methoden können nicht überschrieben werden.

    }
    */

    public void eat(){
        super.eat();
        System.out.println("... und frisst Fleisch!");
    }

    @Override
    public void breath(){
        System.out.println("Der Hund " + getDescription() + " atmet! *hechel* ");
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public String toString(){
        return super.toString() + "; Rasse: " + getBreed();
    }
}
