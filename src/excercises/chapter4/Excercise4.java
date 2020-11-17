package excercises.chapter4;

public class Excercise4 {

    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;

        boolean erg = (a==b) ? false : true;

        // Mögliche Lösung 1
        erg = a!=b;
        // Mögliche Lösung 2
        erg = !(a==b);


        // Nicht erlaubte Lösung - nach Aufgenstellung
        if(a==b){
            erg = false;
        }else{
            erg = true;
        }
    }

    static boolean operation(){
        boolean a = true;
        boolean b = false;

        //return a==b ? false : true;
        return a!=b;
    }
}
