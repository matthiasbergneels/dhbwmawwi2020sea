package excercises.chapter7.clone;

public class CloneMachine {

    public static void main(String[] args) {

        Sheep dolly = new Sheep("Dolly", 3);

        try {
            Sheep dolly2 = dolly.clone();

            System.out.println("Dolly Orginal: " + dolly.name + " - " + dolly.age);
            System.out.println("Dolly Clone: " + dolly2.name + " - " + dolly2.age);

            dolly2.name = "Gabi";

            System.out.println("Dolly Orginal: " + dolly.name + " - " + dolly.age);
            System.out.println("Dolly Clone: " + dolly2.name + " - " + dolly2.age);

        }catch (Exception e){
            System.out.println("Ausnahme aufgetreten!");
            System.out.println(e.getMessage());
        }
    }
}
