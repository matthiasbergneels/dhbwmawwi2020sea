package lecture.chapter12;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList myWordList = new LinkedList();

        myWordList.add("Hallo");
        myWordList.add("Klaus");
        myWordList.add("Hihihi");

        System.out.println("Liste gefüllt!");

        System.out.println("Enthält Hallo: " + myWordList.contains("Hallo"));
        System.out.println("Enthält Klaus: " + myWordList.contains("Klaus"));
        System.out.println("Enthält Hihihi: " + myWordList.contains("Hihihi"));

    }
}
