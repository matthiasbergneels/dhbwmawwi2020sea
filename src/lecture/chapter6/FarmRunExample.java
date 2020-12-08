package lecture.chapter6;

public class FarmRunExample {

    public static void main(String[] args) {

        // Animal myAnimal = new Animal(30.0f, "Dingsda", 10.0f); --> ist abstrakt
        Dog bello = new Dog(75.0f, "Bello",
                50.0f, "Dobermann");
        Dog hasso = new Dog(50.0f, "Hasso",
                50.0f, "Mischling");
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

        hasso.eat();
        hasso.breath();
        hasso.move();

        tweety.eat();
        tweety.move();
        tweety.breath();

        /*

        myAnimal.eat();
        myAnimal.breath();
        myAnimal.move();
         */

        System.out.println(bello.toString());
        System.out.println(hasso.toString());
        System.out.println(tweety.toString());
        //System.out.println(myAnimal.toString());

        //System.out.println(myAnimal);




        // narrowing Cast --> Sichtbarkeit einschränken
        // impliziter Cast --> weil ein Hund ein Tier ist / ein Vogel ein Tier ist
        Animal animalOne = hasso;
        Animal animalTwo = tweety;

        animalOne.move();
        animalTwo.move();



        // widening Cast --> Sichtbarkeit erweitern
        // unsicherer Cast --> explizit casten

        if(animalOne instanceof Dog){
            Dog dogOne = (Dog)animalOne;

            dogOne.move();
            dogOne.bark();
            System.out.println("Rasse: " + dogOne.getBreed());
        }

        if(animalTwo instanceof Dog){
            Dog dogTwo = (Dog)animalTwo; // --> schlägt fehl, weil ein Vogel kein Hund ist!

            dogTwo.move();
            dogTwo.bark();
        }else{
            System.out.println("AnimalTwo ist KEIN Hund!");
        }


        // narrowing Cast
        Object objectOne = hasso;

        System.out.println(objectOne.toString());


        Animal[] animalBox = new Animal[5];

        animalBox[0] = bello;
        animalBox[1] = tweety;
        animalBox[2] = hasso;
        animalBox[3] = new Bird(5.0f, "Birdy", 1.5f, true);
        animalBox[4] = new Bird(50.0f, "Pingu", 1.5f, false);

        System.out.println("Bauer läuft durch den Stall:");
        for(Animal currentAnimal : animalBox){
            currentAnimal.move();
            currentAnimal.eat();
            currentAnimal.breath();

            if(currentAnimal instanceof Dog){
                Dog currentDog = (Dog)currentAnimal;
                currentDog.bark();
            }
        }

    }

}
