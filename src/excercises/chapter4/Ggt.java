package excercises.chapter4;

public class Ggt {

    public static void main(String[] args) {

        int numberA = 245;
        int numberB = 63;

        numberA = calculateGgt(numberA, numberB);

        System.out.println("Der GGT ist: " + numberA);

    }

    public static int calculateGgt(int numberA, int numberB) {
        while(numberA != numberB){
            if(numberA > numberB){
                numberA = numberA - numberB;
                //numberA -= numberB;
            }else{
                numberB = numberB - numberA;
            }
        }
        return numberA;
    }
}
