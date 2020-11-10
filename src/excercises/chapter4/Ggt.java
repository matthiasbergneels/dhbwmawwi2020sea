package excercises.chapter4;

public class Ggt {

    public static void main(String[] args) {

        int numberA = 245;
        int numberB = 0;

        while(numberA != numberB){
            if(numberA > numberB){
                numberA = numberA - numberB;
                //numberA -= numberB;
            }else{
                numberB = numberB - numberA;
            }
        }

        System.out.println("Der GGT ist: " + numberA);

    }
}
