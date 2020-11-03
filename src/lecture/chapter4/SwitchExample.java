package lecture.chapter4;

public class SwitchExample {

    public static void main(String[] args) {

        int grade = 2;

        switch(grade){
            case 1:
                System.out.println("Sehr gut");
                break;
            case 2:
                System.out.println("Gut");
                break;
            case 3:
                System.out.println("Befriedigend");
                break;
            case 4:
                System.out.println("Ausreichend");
                break;
            case 5:
                System.out.println("Ungenügend");
                break;
            default:
                System.out.println("Diese Note gibt es nicht. ");
        }

        System.out.println("Ende der Benotung!");

    }
}
