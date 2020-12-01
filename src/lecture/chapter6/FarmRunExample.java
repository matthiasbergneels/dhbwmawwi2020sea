package lecture.chapter6;

public class FarmRunExample {

    public static void main(String[] args) {

        Dog bello = new Dog(75.0f, "Bello",
                50.0f, "Dobermann");

        System.out.println("Bello - wiegt: " + bello.getWeight());

        // Definiert in Klasse Dog
        bello.bark();

        // Definiert in Klasse Animal --> vererbt zu Hund
        bello.eat();
        bello.breath();
        bello.move();

    }
}
