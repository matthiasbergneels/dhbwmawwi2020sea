package lecture.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentsInContainers {

    public static void main(String[] args) {

        Set<Student> myStudentSet = new TreeSet<Student>();

        myStudentSet.add(new Student(12345, "Gabi", "Zeusfewef", 22));
        myStudentSet.add(new Student(98273, "Hans", "Mayer", 23));
        myStudentSet.add(new Student(73829, "Florian", "Frisch", 21));
        myStudentSet.add(new Student(72112, "Gabi", "Zeus", 22));
        myStudentSet.add(new Student(93821, "Gabi", "Zeus", 22));

        // Dublikat --> kein Dublikat nach neuer "natürlicher Ordnung"
        myStudentSet.add(new Student(73829, "Florian2", "Frischewfas", 21));
        myStudentSet.add(new Student(12345, "Gabi", "Maus", 22));

        // Dublikat --> auch nach neuer natürlicher Ordnung
        myStudentSet.add(new Student(98273, "Hans", "Mayersdfsdf", 25));

        Iterator<Student> myStudentSetIterator = myStudentSet.iterator();
        while(myStudentSetIterator.hasNext()){
            Student myStudent = myStudentSetIterator.next();
            System.out.println(myStudent.getStudentId() + ": " + myStudent.getFamilyName() + ", " + myStudent.getName());
        }


        System.out.println("Anzahl Studenten: " + myStudentSet.size());


        System.out.println("Student Set sorted by Age:");
        Set<Student> myStudentSetByAge = new TreeSet<>(new StudentSortByAge());

        myStudentSetByAge.addAll(myStudentSet);

        for(Student myStudent: myStudentSetByAge){
            System.out.println(myStudent.getStudentId() + ": " + myStudent.getFamilyName() + ", " + myStudent.getName() + "; " + myStudent.getAge());
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
            System.out.println(myStudent.getStudentId() + ": " + myStudent.getFamilyName() + ", " + myStudent.getName() + "; " + myStudent.getAge());
        }




    }
}
