package lecture.chapter6;

public class FarmRunExample {

    public static void main(String[] args) {

        Dog bello = new Dog(75.0f, "Bello",
                50.0f, "Dobermann");
        Bird tweety = new Bird(10.0f, "Tweety",
                0.3f, true);

        System.out.println("Bello - wiegt: " + bello.getWeight());
        System.out.println("Tweety - wiegt: " + tweety.getWeight());

        // Definiert in Klasse Dog
        bello.bark();
        // tweety.bark(); --> Ein Vogel kann nicht bellen!

        // Definiert in Klasse Bird
        tweety.tweet();

        // Definiert in Klasse Animal --> vererbt zu Hund
        bello.eat();
        bello.breath();
        bello.move();

        tweety.eat();
        tweety.move();
        tweety.breath();

    }
}
