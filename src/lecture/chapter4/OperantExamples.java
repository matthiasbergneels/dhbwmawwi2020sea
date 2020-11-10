package lecture.chapter4;

public class OperantExamples {

    public static void main(String[] args) {

        int numberA;

        numberA = 5 + 6; // ==> numberA = 11

        numberA = 6 % 4; // ==> numberA = 2

        {
            // Anweisungsblock
           int innerNumber = 6;
           numberA = numberA + innerNumber;
        }

        // numberA = innerNumber;

        numberA = 5;

        // Post-Dekrement;
        numberA++; // Äquivalent: numberA = numberA + 1;

        System.out.println(numberA);

        // Pre-Dekrement
        ++numberA;

        System.out.println(numberA);


        int result;
        int numberB = 5;
        numberA = 5;

        // Post (nach) inkrement
        result = numberA++ + numberB; // DANACH: result = 10; numberA = 6; numberB = 5;

        /* Äquivalent
        result = numberA + numberB;
        numberA = numberA + 1;

         */
        System.out.println("Post Inkrement:");
        System.out.println(result);
        System.out.println(numberA);
        System.out.println(numberB);

        result = 0;
        numberA = 5;
        numberB = 5;

        // Pre (vor) inkrement)
        result = ++numberA + numberB; // DANACH: result = 11; numberA = 6; numberB = 5;

        /* Äquivalent
        numberA = numberA + 1;
        result = numberA + numberB;

         */
        System.out.println("Pre-Inkrement:");
        System.out.println(result);
        System.out.println(numberA);
        System.out.println(numberB);


        numberA = numberB; // = Zuweisung

        System.out.println(numberA == numberB); // == Vergleich


        boolean isTired = true;

        System.out.println( !isTired );

        boolean isAtHome = true;

        boolean goToBed = isTired && isAtHome;

        /*
        Wahrheitstabellen:
         &/&&   true    false
        true    true    false
        false   false   false


         |/||   true    false
        true    true    true
        false   true    false

         ^      true    false
        true    false   true
        false   true    false


         */

        numberA += numberB;     // Äquivalent: numberA = numberA + numberB;



        // Fragezeichen-Operator

        isTired = false;
        String output = isTired ? "Ich bin müde" : "Ich wach";
        System.out.println(output);

        output = (isTired && isAtHome) ? "Ich gehe ins Bett!" : "Ich muss wach bleiben!";
        System.out.println(output);

        if(isTired && isAtHome){
            output = "Ich gehe ins Bett!";
        }else{
            output = "Ich muss wach bleiben!";
        }


        // String-Verkettung

        String textA = "Hallo";
        String textB = "Welt";

        String textResult = "" + numberA + numberB + textA + " " + textB + (numberB + numberA);
        System.out.println(textResult);
    }
}
