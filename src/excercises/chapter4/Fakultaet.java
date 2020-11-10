package excercises.chapter4;

import javax.swing.JOptionPane;


public class Fakultaet {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog("Geben Sie eine Zahl ein:");
        int fakultaet = Integer.parseInt(s);

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
