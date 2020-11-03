package lecture.chapter3;

public class LiteralExamples {

    public static void main(String[] args) {

        int numberA;

        // Ganzzahlen Literale

        // Dezimalliteral --> Zahlen 0 - 9
        numberA = 78;
        System.out.println(numberA); // Ausgabe: 153

        // Oktalliteral --> präfix 0 Zahlen 0-7
        numberA = 071;
        //numberA = 57;
        System.out.println(numberA); // Ausgabe: 57 (7*8^1+1*8^0)

        // Hexadezimalliteral --> präfix 0x Zahlen 0-9 & Buchstaben A-F
        numberA = 0x1A;
        System.out.println(numberA); // Ausgabe: 26 (1*16^1+10*16^0)

        // Binärliteral --> präfix 0b Zahlen 0 & 1
        numberA = 0b11;
        System.out.println(numberA); // Ausgabe: 3

        // Long Literal --> größer als Integer-Wertebereich
        long largeNumberB = 3000000000L;


        // Gleitkomma-Literal

        double numberC;

        numberC = .5; // 0.5
        System.out.println(numberC); // Ausgabe: 0.5

        numberC = 45.153e2d;
        System.out.println(numberC); // Ausgabe: 4515.3

        numberC = 45.153e-2d;
        System.out.println(numberC); // Ausgabe: 0.45153

        float numberD;

        // float literal --> Suffix "f"
        numberD = 3.14e2f;


        // Alphanumerische Literale

        char singleCharacter;

        singleCharacter = 'v';
        System.out.println(singleCharacter); // Ausgabe: v

        singleCharacter = '\u2764';
        System.out.println(singleCharacter); // Ausgabe: ❤

        singleCharacter = 65; // ! Dezimalliteral
        System.out.println(singleCharacter); // Ausgabe: A


        String multipleCharacters;

        multipleCharacters = "Hier steht \t ein \"Text\" aus\nvielen Zeichen! \u2764 \ud83d\udc3b";
        System.out.println(multipleCharacters);
        /* Ausgabe:
        Hier steht 	 ein "Text" aus
        vielen Zeichen! ❤
        */
    }
}
