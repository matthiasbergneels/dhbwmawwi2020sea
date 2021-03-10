package lecture.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {

        Set<String> myNameSet = new TreeSet<String>();

        myNameSet.add("Katrin");
        myNameSet.add("Adam");
        myNameSet.add("Sabine");
        myNameSet.add("Zeus");
        myNameSet.add("Harald");
        System.out.println(myNameSet.add("Adam"));

        System.out.println("Anzahl Namen: " + myNameSet.size());
        System.out.println("Enthält Adam: " + myNameSet.contains("Adam"));

        System.out.println("Iteration: For-Each");
        for(String name : myNameSet){
            System.out.println("Name: " + name);
        }

        System.out.println("Iteration: Iterator");
        Iterator<String> myNameSetIterator = myNameSet.iterator();
        while(myNameSetIterator.hasNext()){
            String name = myNameSetIterator.next();
            System.out.println("Name: " + name);
            if(name.equals("Harald")){
                myNameSetIterator.remove();
            }
        }

        System.out.println("Anzahl Namen: " + myNameSet.size());
        System.out.println("Lösche Harald: " + myNameSet.remove("Harald"));
        System.out.println("Lösche Harald: " + myNameSet.remove("Harald"));
        System.out.println("Anzahl Namen: " + myNameSet.size());

        myNameSet.clear();
        System.out.println("Anzahl Namen: " + myNameSet.size());
    }
}
