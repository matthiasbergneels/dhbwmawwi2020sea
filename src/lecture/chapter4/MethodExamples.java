package lecture.chapter4;

public class MethodExamples {

    public static void main(String[] args) {

        int numberA = 5;
        int numberB = 10;

        //int result = numberA + numberB;
        int result = add(numberA, numberB);

        //result = result + numberB;
        result = add(result, numberB);

        System.out.println("Ergebnis: " + result);
    }

    static int add(int parameterA, int parameterB){
        int addResult = parameterA + parameterB;

        return addResult;
    }
}
