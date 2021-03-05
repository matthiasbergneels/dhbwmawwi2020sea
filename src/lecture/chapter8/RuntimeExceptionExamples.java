package lecture.chapter8;

public class RuntimeExceptionExamples {

    public static void main(String[] args) {

        int[] numbers = {5, 4, 3, 2, 1};

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        try {
            System.out.println(numbers[3]);
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
            System.out.println("Dürfen wird nicht!");
            return;
        }finally {
            // Hier wird aufgeräumt
            System.out.println("Ich werde immer ausgeführt!");
        }


        System.out.println("Hier geht es weiter!");

    }
}
