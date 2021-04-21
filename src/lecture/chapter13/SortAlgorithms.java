package lecture.chapter13;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] unsortedNumbers = {50, 30, 80, 40, 60, 100, 20, 70, 10, 90};

        int[] sortedNumbers = bubbleSortNumberArrayV1(unsortedNumbers.clone());

        System.out.println("Sortierte Zahlen - bubbleSort: ");
        for(int number : sortedNumbers){
            System.out.print(number + "; ");
        }
    }

    public static int[] bubbleSortNumberArrayV1(int numbers[]){

        for (int i = 0; i < numbers.length; i++){
            System.out.println("- Äußere Schleife Durchlauf " + i);
            for(int j = 0; j < (numbers.length - 1); j++){
                System.out.println("-- Innere Schleife Durchlauf " + i + "-" + j);
                if(numbers[j] > numbers[j+1]){
                    int cache = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = cache;
                    System.out.println("--- Getauscht! " + i + "-" + j);
                }
            }
        }

        return numbers;
    }

    public static int[] bubbleSortNumberArrayV2(int numbers[]){

        for (int i = 0; i < numbers.length; i++){
            System.out.println("- Äußere Schleife Durchlauf " + i);
            for(int j = 0; j < (numbers.length - 1 - i); j++){
                System.out.println("-- Innere Schleife Durchlauf " + i + "-" + j);
                if(numbers[j] > numbers[j+1]){
                    int cache = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = cache;
                    System.out.println("--- Getauscht! " + i + "-" + j);
                }
            }
        }

        return numbers;
    }


    public static int[] bubbleSortNumberArrayV3(int numbers[]){


        return numbers;
    }
}
