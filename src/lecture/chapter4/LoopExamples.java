package lecture.chapter4;

public class LoopExamples {

    public static void main(String[] args) {

        // While Example
        int count = 0;
        System.out.println("While Schleife 0 - 10:");
        while(count <= 10 ){
            if(!(count % 3 == 0)){
                count++;
                System.out.println("Nicht durch drei teilbar!");
                continue;
            }
            System.out.println(count);
            count++;
        }


        // Do-While Example
        count = 0;
        System.out.println("Do-While Schleife 0 - 10:");
        do {
            if(count == 6){
                System.out.println("Die böse Zahl - sofort aufhören zu zählen.");
                break;
            }
            System.out.println(count);
            count++;
        }while(count <= 10);


        // Zähler-Schleife (for)
        System.out.println("For Schleife 0 - 10:");
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }


        // Very Bad stile!! :-(
        count = 0;
        for(;;){
            System.out.println(count);
            count++;
            if(count > 10){
                break;
            }
        }
    }
}
