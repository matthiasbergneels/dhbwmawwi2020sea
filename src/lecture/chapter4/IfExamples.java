package lecture.chapter4;

public class IfExamples {

    public static void main(String[] args) {

        boolean isTired = false;

        System.out.println("Geschichten, die das Leben schreibt:");

        if (isTired) {
            System.out.println("Ich gehe ins Bett!");
            System.out.println("Gute Nacht!");
        } else {
            System.out.println("Ich gehe joggen!");
        }

        System.out.println("Ende der Geschichte");




        short grade = 3;

        if(grade <= 2){
            System.out.println("Damit bin ich sehr zufrieden!");
        }else if(grade == 4){
            System.out.println("Das war richtig knapp");
        }else if(grade > 4){
            System.out.println("Die Klausur muss ich wiederholen!");
        }else{
            System.out.println("Das hätte besser sein können!");
        }



    }
}
