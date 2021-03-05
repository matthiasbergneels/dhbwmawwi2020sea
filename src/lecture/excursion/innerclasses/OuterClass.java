package lecture.excursion.innerclasses;

public class OuterClass {

    // inneren Top-Level Klasse
    static class InnerTopLevelClass{

        void print(String message){
            System.out.println(InnerTopLevelClass.class.getName() + " - Innere Top-Level Klasse sagt: " + message);
        }
    }

    // innere Element Klasse
    class InnerElementClass{
        void print(String message){
            System.out.println(InnerElementClass.class.getName() + " - Innere Element Klasse sagt: " + message);
        }
    }

    void printFromInnerLocalClass(String message){
        class InnerLocalClass{
            void print(String message){
                System.out.println(InnerLocalClass.class.getName() + " - Innere lokale Klasse sagt: " + message);
            }
        }

        InnerLocalClass myInnerLocalClass = new InnerLocalClass();
        myInnerLocalClass.print(message);
    }


    public static void main(String[] args) {
        String message = "Hello World";

        System.out.println(OuterClass.class.getName() + " - Äußere Klasse sagt: " + message);

        OuterClass.InnerTopLevelClass myInnerTopLevelClass = new OuterClass.InnerTopLevelClass();
        myInnerTopLevelClass.print(message);

        OuterClass myOuterClass = new OuterClass();
        InnerElementClass myInnerElementClass = myOuterClass.new InnerElementClass();
        myInnerElementClass.print(message);

        myOuterClass.printFromInnerLocalClass(message);


    }
}
