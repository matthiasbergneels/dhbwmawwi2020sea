package excercises.chapter4;

import java.util.Scanner;


public class Fakultaet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int fakultaet = scanner.nextInt();

        int result = 1;

        for(int i = 1; i <= fakultaet; i++){
            result = result * i;
        }

        System.out.println("Fakultät von " + fakultaet + ": " + result);



        // Alternative
        result = 1;
        while(fakultaet > 0){
            result = result * fakultaet--;
        }

        System.out.println("Fakultät ist: " + result);

    }
}
