package lecture.chapter3;

public class ArrayExamples {

    public static void main(String[] args) {

        // Integer Array Deklaration
        int[] numbers;

        // Integer Array Initialisierung
        numbers = new int[10];

        numbers[0] = 154;
        numbers[1] = 42;
        numbers[5] = 199;
        numbers[9] = 999;

        System.out.println(numbers[5]);
        System.out.println(numbers[2]);


        // Deklaration String Array & initialisierung über Array literal
        //      Index:      0        1         2        3
        String[] words = {"hallo", "Welt", "Kuchen", "Auto"};

        System.out.println(words[2]);


        String[][] sentences;

        sentences = new String[5][];
        sentences[0] = new String[2];

        sentences[0][0] = "Hello";
        sentences[0][1] = "World!";

        sentences[1] = new String[3];

        sentences[1][0] = "Ich";
        sentences[1][1] = "hab";
        sentences[1][2] = "hunger";


        char[][] tictactoe = new char[3][3];

        tictactoe[1][1] = 'X';
        tictactoe[0][1] = 'O';
        tictactoe[2][0] = 'X';
    }
}
