package lecture.chapter9;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentsInContainers {

    public static void main(String[] args) {

        Set<Student> myStudentSet = new TreeSet<Student>();

        Student student0 = new Student(12345, "Gabi", "Zeus", 22);
        Student student1 = new Student(93821, "Gabi", "Zeus", 22);
        Student student2 = new Student(93821, "Gabi", "Zeus", 22);
        Student student3 = new Student(73829, "Florian", "Frisch", 21);
        Student student4 = student3;

        // Vergleichen von Objekten

        if(student1 == student3){
            System.out.println("Die Studenten sind identisch");
        }else{
            System.out.println("Die Studenten sind nicht identisch");
        }

        System.out.println("Alias Vergleich mit ==");
        System.out.println("Unterschiedliche Objekte, unterschiedlicher Inhalt: "+(student1 == student3)); // --> false
        System.out.println(student3 == student3); // --> true
        System.out.println(student4 == student3); // --> true
        System.out.println(student1 == student2); // --> false

        System.out.println("Vergleich mit Equals:");
        System.out.println(student1.equals(student3)); // --> false
        System.out.println(student3.equals(student3)); // --> true
        System.out.println(student4.equals(student3)); // --> true
        System.out.println(student1.equals(student2)); // --> true

        System.out.println("HashCode() Werte:");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student4.hashCode());


        myStudentSet.add(student0);
        myStudentSet.add(new Student(98273, "Hans", "Mayer", 23));
        myStudentSet.add(student3);
        myStudentSet.add(new Student(72112, "Gabi", "Zeus-Münster", 22));
        myStudentSet.add(student2);

        // Dublikat --> kein Dublikat nach aktueller "natürlicher Ordnung"
        myStudentSet.add(new Student(73829, "Florian2", "Frischer", 21));
        myStudentSet.add(new Student(12345, "Gabi", "Maus", 22));

        // Dublikat --> auch nach aktueller natürlicher Ordnung
        myStudentSet.add(new Student(98273, "Hans", "Mayer", 25));

        Iterator<Student> myStudentSetIterator = myStudentSet.iterator();
        while(myStudentSetIterator.hasNext()){
            Student myStudent = myStudentSetIterator.next();
            System.out.println(myStudent);
        }


        System.out.println("Anzahl Studenten: " + myStudentSet.size());


        System.out.println("Student Set sorted by Age:");
        Set<Student> myStudentSetByAge = new TreeSet<>(new StudentSortByAge());

        myStudentSetByAge.addAll(myStudentSet);

        for(Student myStudent: myStudentSetByAge){
            System.out.println(myStudent);
        }


        System.out.println("Student Set sorted by Age and Sign:");
        Set<Student> myStudentSetByAgeAndSigns = new TreeSet<>((Student o1, Student o2) -> {
            if(o1.getAge() != o2.getAge()){
                return o1.getAge() - o2.getAge();
            }

            return o1.getFamilyName().length() - o2.getFamilyName().length();
        });

        myStudentSetByAgeAndSigns.addAll(myStudentSet);

        for(Student myStudent: myStudentSetByAgeAndSigns){
            System.out.println(myStudent);
        }


        Set<Student> myHashStudentSet = new HashSet<>();

        myHashStudentSet.addAll(myStudentSet);

        System.out.println(myHashStudentSet.add(student1));
        System.out.println(myHashStudentSet.add(student1));

        System.out.println("Hash Student Set: ");
        for(Student myStudent : myHashStudentSet){
            System.out.println(myStudent);
        }

    }
}
