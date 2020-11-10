package lecture.chapter3;

public class ArrayExamples {

    public static void main(String[] args) {

        // Integer Array Deklaration
        int[] numbers;

        int count = 50;

        // Integer Array Initialisierung
        numbers = new int[count];

        numbers[0] = 154;
        numbers[1] = 42;
        numbers[5] = 199;
        numbers[9] = 999;

        System.out.println(numbers[1]);
        System.out.println(numbers[5]);
        System.out.println(numbers[2]);

        System.out.println(numbers.length);

        System.out.println("Ausgabe gesamtes numbers Array mit for Schleife:");
        for(int i = 0; i < numbers.length; i++){
            System.out.println("Index " + i + ":" + numbers[i]);
        }

        System.out.println("Ausgabe gesamtes numbers Array mit while Schleife:");
        int numbersIndex = 0;

        while (numbersIndex < numbers.length){
            System.out.println("Index " + numbersIndex + ":" + numbers[numbersIndex]);
            numbersIndex++;
        }

        // initialisiert ein neues Array
        numbers = new int[11];

        System.out.println(numbers[1]);



        // Deklaration String Array & initialisierung über Array literal
        //      Index:      0        1         2        3
        String[] words = {"hallo", "Welt", "Kuchen", "Auto"};
        /*
        String[] words = new String[4];
        words[0] = "hallo";
        words[1] = "Welt";
        ...

         */

        System.out.println(words[2]);
        System.out.println(words.length);


        String[][] sentences;

        sentences = new String[5][];
        sentences[0] = new String[2];

        sentences[0][0] = "Hello";
        sentences[0][1] = "World!";

        sentences[1] = new String[3];

        sentences[1][0] = "Ich";
        sentences[1][1] = "hab";
        sentences[1][2] = "hunger";


        for(int i = 0; i < sentences.length; i++){
            for(int j = 0; j < sentences[i].length; j++){
                System.out.print(sentences[i][j] + " ");
            }
            System.out.println();
        }


        char[][] tictactoe = new char[3][3];

        tictactoe[1][1] = 'X';
        tictactoe[0][1] = 'O';
        tictactoe[2][0] = 'X';

        System.out.println(tictactoe[1][1]);
    }
}
