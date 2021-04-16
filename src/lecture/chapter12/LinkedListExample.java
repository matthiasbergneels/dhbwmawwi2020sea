package lecture.chapter12;

import lecture.chapter11.Person;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> myWordList = new LinkedList<String>();

        myWordList.add("Hallo");
        myWordList.add("Klaus");
        myWordList.add("Hihihi");
        // myWordList.add(new Person("", "")); --> Generic Typisierung

        System.out.println("Liste gefüllt!");

        System.out.println("Contains - Iterarativ");
        System.out.println("Enthält Hallo: " + myWordList.contains("Hallo"));
        System.out.println("Enthält Klaus: " + myWordList.contains("Klaus"));
        System.out.println("Enthält Hihihi: " + myWordList.contains("Hihihi"));

        System.out.println("Contains - Rekursiv");
        System.out.println("Enthält Hallo: " + myWordList.recursiveContains("Hallo"));
        System.out.println("Enthält Klaus: " + myWordList.recursiveContains("Klaus"));
        System.out.println("Enthält Hihihi: " + myWordList.recursiveContains("Hihihi"));

        myWordList.printList();

        System.out.println("Lösche Klaus: " + myWordList.remove("Klaus"));

        myWordList.printList();

        System.out.println("Lösche Hallo: " + myWordList.remove("Hallo"));
        System.out.println("Lösche Hallo: " + myWordList.remove("Hallo"));

        myWordList.printList();

        System.out.println("Lösche Hihihi: " + myWordList.remove("Hihihi"));

        myWordList.printList();
    }
}
