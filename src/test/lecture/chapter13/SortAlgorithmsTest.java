package test.lecture.chapter13;

import lecture.chapter13.SortAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest {

    static int count = 25000;
    static int randomRange = 3000000;
    static int[] toSort = null;

    @BeforeEach
    void setUp() {
        generateArray();
    }

    @Test
    void bubbleSortNumberArrayV1() {
        int[] bubbleSortedArray = SortAlgorithms.bubbleSortNumberArrayV1(toSort.clone());
        assertTrue(isSorted(bubbleSortedArray));
    }

    @Test
    void bubbleSortNumberArrayV2() {
        int[] bubbleSortedArray = SortAlgorithms.bubbleSortNumberArrayV2(toSort.clone());
        assertTrue(isSorted(bubbleSortedArray));
    }

    @Test
    void bubbleSortNumberArrayV3() {
        int[] bubbleSortedArray = SortAlgorithms.bubbleSortNumberArrayV3(toSort.clone());
        assertTrue(isSorted(bubbleSortedArray));
    }

    @Test
    void selectionSortNumberArray() {
        int[] selectionSortedArray = SortAlgorithms.selectionSortNumberArray(toSort.clone());
        assertTrue(isSorted(selectionSortedArray));
    }

    @Test
    void quickSortNumberArray() {
        int[] quickSortedArray = SortAlgorithms.quickSortNumberArray(toSort.clone());
        assertTrue(isSorted(quickSortedArray));
    }

    private static boolean isSorted(int[] array){
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }


    private static void generateArray(){
        toSort = new int[count];
        for(int i = 0; i < count; i++){
            boolean notInserted = true;
            while(notInserted){
                int randomNumber = (int)(Math.random() * randomRange);

                boolean found = false;
                for(int j = 0; j < i; j++){
                    if(toSort[j] == randomNumber){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    toSort[i] = randomNumber;
                    notInserted = false;
                }

            }
        }
    }
}
