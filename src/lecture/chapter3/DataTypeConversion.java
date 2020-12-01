package lecture.chapter3;

public class DataTypeConversion {

    public static void main(String[] args) {

        byte numberA = 50;
        int numberB;

        // implizite Typumwandlung (von byte zu int) / implicit type cast
        numberB = numberA; // --> numberB = 50;

        numberB = 130;

        //  explizite Typumwandlung (bsp. von int zu byte) / explicit type cast --> cast operator "()"
        numberA = (byte)numberB;


        System.out.println(numberA);
        System.out.println(numberB);



    }
}
