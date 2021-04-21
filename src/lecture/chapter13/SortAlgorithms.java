package lecture.chapter13;

public class SortAlgorithms {

    public static void main(String[] args) {
        int[] unsortedNumbers = {50, 30, 80, 40, 60, 100, 20, 70, 10, 90};

        int[] sortedNumbers = bubbleSortNumberArrayV1(unsortedNumbers.clone());
        System.out.println("Sortierte Zahlen - bubbleSortV1: ");
        printArray(sortedNumbers);


        sortedNumbers = bubbleSortNumberArrayV1(unsortedNumbers.clone());
        System.out.println("Sortierte Zahlen - bubbleSortV2: ");
        printArray(sortedNumbers);


        sortedNumbers = bubbleSortNumberArrayV1(unsortedNumbers.clone());
        System.out.println("Sortierte Zahlen - bubbleSortV3: ");
        printArray(sortedNumbers);


    }

    public static int[] bubbleSortNumberArrayV1(int numbers[]){

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++){
            for(int j = 0; j < (numbers.length - 1); j++){
                if(numbers[j] > numbers[j+1]){
                    swap(numbers, j, j+1);
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("BubbleSort V1 Runtime: " + (endTime - startTime) + " ms");

        return numbers;
    }

    public static int[] bubbleSortNumberArrayV2(int numbers[]){

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++){
            for(int j = 0; j < (numbers.length - 1 - i); j++){
                if(numbers[j] > numbers[j+1]){
                    swap(numbers, j, j+1);
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("BubbleSort V2 Runtime: " + (endTime - startTime) + " ms");

        return numbers;
    }


    public static int[] bubbleSortNumberArrayV3(int numbers[]){

        int j = numbers.length - 1;
        boolean swapped = false;

        long startTime = System.currentTimeMillis();

        do{
            swapped = false;

            for(int i = 0; i < j; i++){
                if(numbers[i] > numbers[i+1]){
                    swap(numbers, i, i+1);
                    swapped = true;
                }
            }
            j--;
        }while(swapped);

        long endTime = System.currentTimeMillis();

        System.out.println("BubbleSort V3 Runtime: " + (endTime - startTime) + " ms");

        return numbers;
    }

    public static int[] selectionSortNumberArray(int numbers[]){


        return numbers;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void printArray(int[] array){
        System.out.print("Array-Ausgabe: ");
        for(int i : array){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

