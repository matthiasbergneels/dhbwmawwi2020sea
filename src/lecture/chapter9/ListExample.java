package lecture.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        // Typisierung über <Generic>
        List<String> myNameList = new ArrayList<String>();

        myNameList.add("Katrin");
        myNameList.add("Klaus");
        myNameList.add("Florian");
        myNameList.add("Klaus");
        myNameList.add("Franz");
        myNameList.add("Monika");
        myNameList.add("Gernot");
        myNameList.add("Matthias");
        //myNameList.add(new Student());
        //myNameList.add(new Bird(12.9f, "Tweety", 15.0f, true));

        System.out.println("Name Index 1: " + myNameList.get(1));
        System.out.println("Enthält Katrin? " + myNameList.contains("Katrin"));

        System.out.println("Ieration: For-Each");
        for(String name : myNameList){
            System.out.println("Name: " + name);
        }

        System.out.println("Ieration: For");
        for(int i = 0; i < myNameList.size(); i++){
            System.out.println("Name("+i+"): " + myNameList.get(i));
        }

        // Sequentieller Zugriff mit Iteratoren
        System.out.println("Ieration: Iterator");
        Iterator<String> myNameListIterator = myNameList.iterator();
        while(myNameListIterator.hasNext()){
            String name = myNameListIterator.next();
            System.out.println("Name: " + name);
            if(name.equals("Florian")){
                myNameListIterator.remove();
            }
        }



        // Sortieren von Listen
        Collections.sort(myNameList);

        System.out.println("Namen alphabetisch sortiert (natürliche Ordnung)");
        for(String name : myNameList){
            System.out.println(name);
        }

        System.out.println("Namen sortiert nach Anzahl der Buchstaben");
        Collections.sort(myNameList, (o1, o2) -> {
            String name1 = (String)o1;
            String name2 = (String)o2;

            return name1.length() - name2.length();
        });
        for(String name : myNameList){
            System.out.println(name);
        }

        System.out.println("Anzahl Elemente: " + myNameList.size());
        System.out.println("Index 1 löschen: " + myNameList.remove(1));
        System.out.println("Klaus löschen: " + myNameList.remove("Klaus"));
        System.out.println("Klaus löschen: " + myNameList.remove("Klaus"));

        System.out.println("Anzahl Elemente: " + myNameList.size());
        myNameList.clear();
        System.out.println("Anzahl Elemente: " + myNameList.size());
    }
}
