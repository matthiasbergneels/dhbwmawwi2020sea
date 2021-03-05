package lecture.excursion.innerclasses;

public class OuterClass {

    static abstract class InnerAbstractTopLevelClass{

        protected String additionalMessage;

        public InnerAbstractTopLevelClass(String additionalMessage){
            this.additionalMessage = additionalMessage;
        }

        abstract void print(String message);
    }

    public static interface InnerInterface{
        void print(String message);
    }

    // inneren Top-Level Klasse - im Klassen-Kontext
    static class InnerTopLevelClass{

        void print(String message){
            System.out.println(InnerTopLevelClass.class.getName() + " - Innere Top-Level Klasse sagt: " + message);
        }
    }

    // innere Element Klasse - im Klassen-Kontext
    class InnerElementClass{
        void print(String message){
            System.out.println(InnerElementClass.class.getName() + " - Innere Element Klasse sagt: " + message);
        }
    }

    void printFromInnerLocalClass(String message){
        // innere lokale Klasse - in einem Methoden Kontext
        class InnerLocalClass{
            void print(String message){
                //System.out.println(InnerLocalClass.class.getName() + " - Innere lokale Klasse sagt: " + message);
                System.out.println(this.getClass().getName() + " - Innere lokale Klasse sagt: " + message);
            }
        }

        InnerLocalClass myInnerLocalClass = new InnerLocalClass();
        myInnerLocalClass.print(message);
    }

    void printFromInnerAnonymousClass(String message){
        // innere anonyme Klasse - in einem Methoden Kontext
        InnerInterface myAnonymousClass = new InnerInterface() {

            @Override
            public void print(String message) {
                System.out.println(this.getClass().getName() + " - Innere anonyme Klasse sagt: " + message);
            }
        };

        myAnonymousClass.print(message);
    }

    void printFromInnerAnonymousClassExtendsTopLevelClass(String message){
        // innere anonyme Klasse - in einem Methoden Kontext
        InnerAbstractTopLevelClass myAnonymousClass = new InnerAbstractTopLevelClass("Ist voll toll!") {

            @Override
            void print(String message) {
                System.out.println(this.getClass().getName() + " - Innere anonyme Klasse mit extends sagt: " + message + " - " + this.additionalMessage);
            }
        };

        myAnonymousClass.print(message);
    }

    void printFromLambdaFunction(String message){
        // Lambda Funktion als Alternative für innere anonyme Klassen
        InnerInterface myLambdaFunction = (String lambdaMessage) -> {
            System.out.println(this.getClass().getName() + " - Lambda Function: " + message);
        };

        myLambdaFunction.print(message);
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

        myOuterClass.printFromInnerAnonymousClass(message);

        myOuterClass.printFromInnerAnonymousClassExtendsTopLevelClass(message);

        myOuterClass.printFromLambdaFunction(message);
    }
}
